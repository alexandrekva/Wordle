package com.example.wordle.feature_game.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.wordle.feature_game.domain.models.CheckCharEnum
import com.example.wordle.feature_game.domain.models.GameResult
import com.example.wordle.feature_game.domain.models.Guess
import com.example.wordle.feature_game.domain.models.GuessChar

class GameViewModel : ViewModel() {

    companion object {
        const val MAX_GUESSES = 6
    }

    var guesses = mutableStateListOf<Guess>()
        private set

    var currentGuess = mutableStateOf(0)
        private set

    var wrongChars = mutableStateListOf<Char>()
        private set

    var gameStatus = mutableStateOf(GameResult.PLAYING)
        private set

    var gameStarted = false
        private set

    private var word = "barco"

    fun startGame() {
        for (i in 1..MAX_GUESSES) {
            guesses.add(Guess())
        }

        gameStarted = true
    }

    fun resetGame() {
        gameStatus.value = GameResult.PLAYING
        wrongChars.clear()
        currentGuess.value = 0

        guesses.clear()
        for (i in 1..MAX_GUESSES) {
            guesses.add(Guess())
        }
    }

    fun insertChar(char: Char) {
        guesses[currentGuess.value].insertChar(char)
        updateGuessState()
    }

    fun deleteChar() {
        guesses[currentGuess.value].deleteChar()
        updateGuessState()
    }

    fun setGameStatus(status: GameResult) {
        gameStatus.value = status
    }

    fun checkGuess() {
        if (!guesses[currentGuess.value].guess.contains(GuessChar())) {
            when {
                guesses[currentGuess.value].checkGuess(word) -> {
                    gameStatus.value = GameResult.WON
                }
                currentGuess.value == MAX_GUESSES - 1 -> {
                    gameStatus.value = GameResult.LOST
                }
                else -> {
                    addWrongChars(guesses[currentGuess.value].guess)
                    currentGuess.value++
                }
            }
            updateGuessState()
        }
    }

    private fun addWrongChars(guessChars: Array<GuessChar>) {
        val wrongChars = mutableListOf<Char>()

        for (guessChar in guessChars) {
            if (guessChar.status == CheckCharEnum.WRONG_CHAR && guessChar.char != null)
                wrongChars.add(guessChar.char!!)
        }

        this.wrongChars.addAll(wrongChars)
    }

    private fun updateGuessState() {
        guesses[currentGuess.value] = guesses[currentGuess.value]
    }

}