package com.yogesh.dicerollergame.presentation.game_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.yogesh.dicerollergame.R
import com.yogesh.dicerollergame.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    navController: NavHostController,
    player1Name: String,
    player2Name: String,
) {
    val gameViewModel: GameViewModel = viewModel()


    LaunchedEffect(key1 = true) {
        gameViewModel.setupGame(player1Name, player2Name)
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("DICE ROLLING GAME") }, actions = {
            Button(onClick = { gameViewModel.resetGame() }) {
                Text("NEW GAME", fontWeight = FontWeight.Bold)
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent))
    }) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround) {
            Text("Let's Play", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            ScoreBar(gameViewModel)
            DiceImage(diceValue = gameViewModel.diceValue.intValue,
                isRolling = gameViewModel.isRolling.value)
            PlayerButtons(gameViewModel, navController)
        }
    }
}


@Composable
private fun ScoreBar(gameViewModel: GameViewModel) {
    Card(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "${gameViewModel.player1Name.value}'s Score: ${gameViewModel.player1Score.intValue}",
                color = Color.White,
                fontWeight = FontWeight.Bold)
            Text(text = "${gameViewModel.player2Name.value}'s Score: ${gameViewModel.player2Score.intValue}",
                color = Color.White,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun DiceImage(diceValue: Int, isRolling: Boolean) {
    val rotation by animateFloatAsState(targetValue = if (isRolling) 360f else 0f,
        animationSpec = tween(durationMillis = 700),
        label = "diceRotation")

    val imageResource = when (diceValue) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Image(painter = painterResource(id = imageResource),
        contentDescription = "Dice",
        modifier = Modifier
            .size(180.dp)
            .rotate(rotation))
}

@Composable
private fun PlayerButtons(gameViewModel: GameViewModel, navController: NavHostController) {
    val onGameWon: (String) -> Unit = { winnerName ->
        navController.navigate(Routes.WinnerScreen(winnerName)) {
            popUpTo<Routes.PlayerRegisterScreen> { inclusive = true }
        }
    }

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = { gameViewModel.rollDice(onGameWon) },
            enabled = gameViewModel.isPlayer1Turn.value && !gameViewModel.isRolling.value,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)) {
            Text("P1: Roll Dice")
        }
        Button(onClick = { gameViewModel.rollDice(onGameWon) },
            enabled = !gameViewModel.isPlayer1Turn.value && !gameViewModel.isRolling.value,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)) {
            Text("P2: Roll Dice")
        }
    }
}