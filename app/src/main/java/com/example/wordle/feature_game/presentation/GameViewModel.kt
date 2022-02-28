package com.example.wordle.feature_game.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import com.example.wordle.feature_game.domain.models.CheckCharEnum
import com.example.wordle.feature_game.domain.models.GameResultEnum
import com.example.wordle.feature_game.domain.models.Guess
import com.example.wordle.feature_game.domain.models.GuessChar

class GameViewModel: ViewModel() {

    companion object {
        const val MAX_GUESSES = 6
    }

    private val wordsList = listOf(
        "doido", "horda", "carma", "linda", "marco", "jovem", "inata", "xeque", "capaz", "fonte",
        "relva", "ajuda", "tenra", "algum", "anuir", "velar", "ficar", "noite", "apoio", "dorso",
        "vimos", "rigor", "verso", "botar", "vazio", "tanto", "prece", "cruel", "morar", "terra",
        "ambas", "frase", "peste"
    )

    var guesses = mutableStateListOf<Guess>()
        private set

    var currentGuess = mutableStateOf(0)
        private set

    var wrongChars = mutableStateListOf<Char>()
        private set

    var gameStatus = mutableStateOf(GameResultEnum.NOT_STARTED)
        private set

    var gameWord = ""

    fun startGame() {
        gameWord = getRandomWord()

        for (i in 1..MAX_GUESSES) {
            guesses.add(Guess())
        }

        gameStatus.value = GameResultEnum.PLAYING
    }

    fun resetGame() {
        gameStatus.value = GameResultEnum.PLAYING
        gameWord = getRandomWord()
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

    fun checkGuess() {
        if (!guesses[currentGuess.value].guess.contains(GuessChar())) {
            when {
                guesses[currentGuess.value].checkGuess(gameWord) -> {
                    gameStatus.value = GameResultEnum.WON
                }
                currentGuess.value == MAX_GUESSES - 1 -> {
                    gameStatus.value = GameResultEnum.LOST
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

    private fun getRandomWord(): String {
        val randomWordPosition = wordsList.indices.random()

        return wordsList[randomWordPosition]
    }

    private fun updateGuessState() {
        guesses[currentGuess.value] = guesses[currentGuess.value]
    }
}