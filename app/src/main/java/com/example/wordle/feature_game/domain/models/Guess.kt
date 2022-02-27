package com.example.wordle.feature_game.domain.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class Guess {

    companion object {
        const val GUESS_SIZE = 5
    }

    var guess = Array(GUESS_SIZE) { GuessChar() }
        private set

    var currentChar = mutableStateOf(0)
        private set

    var isGuessChecked = false
        private set

    fun insertChar(char: Char) {
        if (currentChar.value in 0 until GUESS_SIZE) {
            guess[currentChar.value].char = char
            currentChar.value++
        }
    }

    fun deleteChar() {
        if (currentChar.value in 1..GUESS_SIZE) {
            guess[currentChar.value - 1].char = null
            currentChar.value--
        }
    }

    fun checkGuess(word: String): Boolean {
        checkChars(word = word, guess = guess)
        isGuessChecked = true
        return getGuess() == word
    }

    private fun checkChars(word: String, guess: Array<GuessChar>) {
        for (i in 0 until GUESS_SIZE) {
            when {
                guess[i].char == word[i] -> {
                    guess[i].status = CheckCharEnum.CHAR_IN_PLACE
                }
                word.contains(char = guess[i].char ?: ' ', ignoreCase = true) -> {
                    guess[i].status = CheckCharEnum.CHAR_OUT_OF_PLACE
                }
                else -> {
                    guess[i].status = CheckCharEnum.WRONG_CHAR
                }
            }
        }
    }

    private fun getGuess(): String? {
        return if (!hasEmptySpaces()) {
            val guessChars = guess.map { it.char }
            guessChars.joinToString("")
        } else null
    }

    private fun hasEmptySpaces(): Boolean {
        for (guessChar in guess) {
            if (guessChar.char == null) return true
        }
        return false
    }
}