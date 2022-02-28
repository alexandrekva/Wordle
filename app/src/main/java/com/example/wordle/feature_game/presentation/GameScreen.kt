package com.example.wordle.feature_game.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.wordle.feature_game.domain.models.GameResultEnum
import com.example.wordle.feature_game.presentation.components.DialogContainer
import com.example.wordle.feature_game.presentation.components.GuessContainer
import com.example.wordle.feature_game.presentation.components.KeyboardComponent
import com.example.wordle.ui.theme.WordleTheme

@Composable
fun GameScreen(gameViewModel: GameViewModel) {
    if (gameViewModel.gameStatus.value == GameResultEnum.NOT_STARTED) gameViewModel.startGame()

    WordleTheme() {
        Scaffold(Modifier.fillMaxSize()) {

            when (gameViewModel.gameStatus.value) {
                GameResultEnum.WON -> DialogContainer(
                    resetGame = gameViewModel::resetGame,
                    GameResultEnum.WON,
                    gameViewModel.gameWord
                )
                GameResultEnum.LOST -> DialogContainer(
                    resetGame = gameViewModel::resetGame,
                    GameResultEnum.LOST,
                    gameViewModel.gameWord
                )
                GameResultEnum.PLAYING -> {}
            }

            Column(
                Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                GuessContainer(
                    guesses = gameViewModel.guesses,
                    currentGuess = gameViewModel.currentGuess
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