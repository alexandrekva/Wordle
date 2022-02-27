package com.example.wordle.feature_game.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wordle.ui.theme.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wordle.feature_game.domain.models.CheckCharEnum
import com.example.wordle.feature_game.domain.models.GuessChar

@Composable
fun CharContainer(guessChar: GuessChar, currentGuess: Boolean, currentChar: Boolean) {

    WordleTheme {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(color = if (currentGuess) DarkOverlay else Color.Transparent)
                .border(
                    width = 2.dp,
                    color = when (guessChar.status) {
                        CheckCharEnum.CHAR_IN_PLACE -> Emerald
                        CheckCharEnum.CHAR_OUT_OF_PLACE -> MaximumYellowRed
                        CheckCharEnum.WRONG_CHAR -> CandyPink
                        else -> MaterialTheme.colors.onBackground
                    },
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = guessChar.char?.toString() ?: "  ",
                style = if (currentChar) MaterialTheme.typography.h4.copy(textDecoration = TextDecoration.Underline) else MaterialTheme.typography.h4,

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharContainer() {
    CharContainer(
        guessChar = GuessChar(status = CheckCharEnum.WRONG_CHAR),
        currentGuess = true,
        currentChar = true
    )
}