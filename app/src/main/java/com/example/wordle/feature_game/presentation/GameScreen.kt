package com.example.wordle.feature_game.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.wordle.feature_game.presentation.components.GuessContainer
import com.example.wordle.feature_game.presentation.components.KeyboardComponent

@Composable
fun GameScreen(gameViewModel: GameViewModel) {
    gameViewModel.startGame()


    MaterialTheme {
        Scaffold(Modifier.fillMaxSize()) {
            if (gameViewModel.correctGuess.value) {
                Dialog(onDismissRequest = gameViewModel::setCorrectGuess) {
                    Text(text = "Correct guess")
                }
            }
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Wordle!", style = MaterialTheme.typography.h4)


                GuessContainer(
                    guesses = gameViewModel.guesses,
                    currentGuess = gameViewModel.currentGuess,
                    currentChar = gameViewModel.currentChar
                )

                KeyboardComponent(
                    wrongChars = gameViewModel.wrongChars,
                    insertChar = gameViewModel::insertChar,
                    deleteChar = gameViewModel::deleteChar,
                    checkGuess = gameViewModel::checkGuess
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun previewGameScreen() {
//    GameScreen(gameViewModel = GameViewModel())
//}