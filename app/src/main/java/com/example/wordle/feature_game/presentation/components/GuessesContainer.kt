package com.example.wordle.feature_game.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wordle.feature_game.domain.models.Guess
import com.example.wordle.feature_game.presentation.GameViewModel

@Composable
fun GuessContainer(
    guesses: SnapshotStateList<Guess>,
    currentGuess: MutableState<Int>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        guesses.forEachIndexed() { index, guess ->
            WordGuessContainer(
                guess = guess,
                currentGuess = index == currentGuess.value,
                currentChar = guess.currentChar
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewGuessContainer() {
    var guesses = remember { mutableStateListOf<Guess>() }
    var currentGuess = remember { mutableStateOf(0) }
    for (i in 1..GameViewModel.MAX_GUESSES) {
        guesses.add(Guess())
    }

    GuessContainer(guesses = guesses, currentGuess = currentGuess)
}