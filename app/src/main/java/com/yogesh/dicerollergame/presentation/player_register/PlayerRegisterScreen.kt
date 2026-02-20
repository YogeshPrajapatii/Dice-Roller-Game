package com.yogesh.dicerollergame.presentation.player_register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.yogesh.dicerollergame.R
import com.yogesh.dicerollergame.navigation.Routes

@Composable
fun PlayerRegisterScreen(navController: NavHostController) {

    var player1Name by remember { mutableStateOf("") }
    var player2Name by remember { mutableStateOf("") }


    val nameRegex = remember { Regex("[a-zA-Z ]+") }
    val isPlayer1NameInvalid = player1Name.isNotBlank() && !player1Name.matches(nameRegex)
    val isPlayer2NameInvalid = player2Name.isNotBlank() && !player2Name.matches(nameRegex)

    val areNamesSame = player1Name.isNotBlank() && player1Name.trim().equals(player2Name.trim(), ignoreCase = true)



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = R.drawable.dice_roller_square),
            contentDescription = "App Logo",
            modifier = Modifier.size(180.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Enter Names of Players", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = player1Name,
            onValueChange = { player1Name = it },
            label = { Text("PLAYER 1") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.85f),
            isError = isPlayer1NameInvalid,
            supportingText = { 
                if (isPlayer1NameInvalid) {
                    Text("Only letters are allowed", color = MaterialTheme.colorScheme.error)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

    
        OutlinedTextField(
            value = player2Name,
            onValueChange = { player2Name = it },
            label = { Text("PLAYER 2") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.85f),
            isError = isPlayer2NameInvalid || areNamesSame,
            supportingText = {
                if (isPlayer2NameInvalid) {
                    Text("Only letters are allowed", color = MaterialTheme.colorScheme.error)
                } else if (areNamesSame) {
                    Text("Names cannot be the same", color = MaterialTheme.colorScheme.error)
                }
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        val isButtonEnabled = player1Name.isNotBlank() && player2Name.isNotBlank() &&
                !isPlayer1NameInvalid && !isPlayer2NameInvalid && !areNamesSame

        Button(
            onClick = {
                navController.navigate(
                    Routes.GameScreen(
                        player1Name = player1Name.trim(),
                        player2Name = player2Name.trim()
                    )
                )
            },
            enabled = isButtonEnabled, 
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(50.dp)
        ) {
            Text("Start Game", fontSize = 18.sp)
        }
    }
}