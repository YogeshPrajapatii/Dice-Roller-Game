package com.yogesh.dicerollergame.presentation.game_screen

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameViewModel : ViewModel() {
    val diceValue = mutableIntStateOf(6)

    val player1Score = mutableIntStateOf(0)
    val player2Score = mutableIntStateOf(0)
    val player1Name = mutableStateOf("Player 1")
    val player2Name = mutableStateOf("Player 2")

    val isPlayer1Turn = mutableStateOf(true)
    val isRolling = mutableStateOf(false)

    private val WINNING_SCORE: Int = 50

    // SET UP GAME
    fun setupGame(p1Name: String, p2Name: String) {
        player1Name.value = p1Name
        player2Name.value = p2Name
    }

    // NEW GAME BUTTON WORK
    fun resetGame() {
        player1Score.intValue = 0
        player2Score.intValue = 0
        diceValue.intValue = 6
        isPlayer1Turn.value = true
        isRolling.value = false
    }

    // DICE ROLLING
    fun rollDice(onGameWon: (winnerName: String) -> Unit) {

        viewModelScope.launch {

            if (isRolling.value) return@launch


            isRolling.value = true

            repeat(8) {
                diceValue.intValue = Random.nextInt(1, 7)
                delay(30)
            }

            
            // FINAL SCORE
            val finalResult = Random.nextInt(1, 7)
            diceValue.intValue = finalResult

            if (isPlayer1Turn.value) {
                player1Score.intValue += finalResult
            } else {
                player2Score.intValue += finalResult
            }

            // CHECKING WINNER
            if (player1Score.intValue >= WINNING_SCORE) {
                onGameWon(player1Name.value)
                return@launch
            } else if (player2Score.intValue >= WINNING_SCORE) {

                onGameWon(player2Name.value)
                return@launch
            }

            // CHANGING TURN
            isPlayer1Turn.value = !isPlayer1Turn.value
            isRolling.value = false
        }


    }
}