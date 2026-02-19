package com.yogesh.dicerollergame.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.yogesh.dicerollergame.presentation.game_screen.GameScreen
import com.yogesh.dicerollergame.presentation.player_register.PlayerRegisterScreen
import com.yogesh.dicerollergame.presentation.splash_screen.SplashScreen
import com.yogesh.dicerollergame.presentation.winner_screen.WinnerScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen,
    ) {

        composable<Routes.SplashScreen> {
            SplashScreen(navController = navController)
        }

        composable<Routes.PlayerRegisterScreen> {
            PlayerRegisterScreen(navController = navController)
        }

        composable<Routes.GameScreen> { navBackStackEntry ->
            val args = navBackStackEntry.toRoute<Routes.GameScreen>()

            GameScreen(navController = navController,
                player1Name = args.player1Name,
                player2Name = args.player2Name)
        }

        composable<Routes.WinnerScreen> { navBackStackEntry ->
            val args = navBackStackEntry.toRoute<Routes.WinnerScreen>()


            WinnerScreen(navController = navController, winnerName = args.winnerName)
        }

    }
}