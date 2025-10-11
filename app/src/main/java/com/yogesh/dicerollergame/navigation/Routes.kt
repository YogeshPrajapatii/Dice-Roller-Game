package com.yogesh.dicerollergame.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    
    @Serializable
    data object SplashScreen: Routes()
    
    @Serializable
    data object PlayerRegisterScreen: Routes()
    
    @Serializable
    data class GameScreen(val player1Name: String,val player2Name: String): Routes()
    
    @Serializable
    data class WinnerScreen(val winnerName: String): Routes()
    
}