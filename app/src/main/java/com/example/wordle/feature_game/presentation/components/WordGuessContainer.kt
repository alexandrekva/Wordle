package com.example.wordle.feature_game.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.dp
import com.example.wordle.feature_game.domain.models.Guess

@Composable
fun WordGuessContainer(guess: Guess, currentGuess: Boolean, currentChar: MutableState<Int>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        guess.guess.forEachIndexed() { index, guessChar ->
            CharContainer(
                guessChar = guessChar,
                currentGuess = currentGuess,
                currentChar = index == currentChar.value && currentGuess
            )
        }
    }
}