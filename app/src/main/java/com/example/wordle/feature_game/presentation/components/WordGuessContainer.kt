package com.example.wordle.feature_game.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.wordle.feature_game.domain.models.Guess
import com.example.wordle.ui.theme_extensions.spacing

@Composable
fun WordGuessContainer(guess: Guess, currentGuess: Boolean, currentChar: MutableState<Int>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium)
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