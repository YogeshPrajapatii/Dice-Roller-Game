package com.yogesh.dicerollergame.presentation.winner_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.yogesh.dicerollergame.R
import com.yogesh.dicerollergame.navigation.Routes


@Composable
fun WinnerScreen(navController: NavHostController, winnerName: String) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.trophy),

            contentDescription = "Winner Trophy", modifier = Modifier.size(300.dp))

        Spacer(modifier = Modifier.height(32.dp))

        Text("Congratulations 🎉", fontWeight = FontWeight.Bold, fontSize = 36.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Text("$winnerName Won The Game !", fontSize = 20.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(40.dp))


        // PLAY AGAIN BUTTON
        Button(onClick = {
            navController.navigate(Routes.PlayerRegisterScreen) {
                popUpTo(Routes.SplashScreen) { inclusive = true }
            }
        },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)) {
            Text("Play Again", fontSize = 18.sp, color = Color.White)
        }

    }


}