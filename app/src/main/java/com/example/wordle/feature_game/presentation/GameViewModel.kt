package com.example.wordle.feature_game.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.wordle.feature_game.domain.models.CheckCharEnum
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

    var currentChar = mutableStateOf(0)
        private set

    var wrongChars = mutableStateListOf<Char>()
        private set

    var correctGuess = mutableStateOf(false)
        private set

    private var word = "barco"

    fun startGame() {
        for (i in 1..MAX_GUESSES) {
            guesses.add(Guess())
        }
    }

    fun insertChar(char: Char) {
        guesses[currentGuess.value].insertChar(char, currentChar)
        updateGuessState()
    }

    fun deleteChar() {
        guesses[currentGuess.value].deleteChar(currentChar)
        updateGuessState()
    }

    fun setCorrectGuess() {
        correctGuess.value = false
    }

    fun checkGuess() {
        if (currentChar.value == Guess.GUESS_SIZE && !guesses[currentGuess.value].guess.contains(
                GuessChar()
            )
        ) {
            if (guesses[currentGuess.value].checkGuess(word)) {
                correctGuess.value = true
            } else {
                addWrongChars(guesses[currentGuess.value].guess)
                currentChar.value = 0
                currentGuess.value++
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