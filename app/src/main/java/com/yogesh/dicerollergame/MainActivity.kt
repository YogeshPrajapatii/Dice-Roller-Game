package com.yogesh.dicerollergame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yogesh.dicerollergame.navigation.AppNavigation
import com.yogesh.dicerollergame.ui.theme.DiceRollerGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerGameTheme {
                AppNavigation()
            }
        }
    }
}

