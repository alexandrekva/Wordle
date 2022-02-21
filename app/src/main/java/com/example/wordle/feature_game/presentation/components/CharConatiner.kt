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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wordle.R
import com.example.wordle.feature_game.domain.models.CheckCharEnum
import com.example.wordle.feature_game.domain.models.GuessChar

@Composable
fun CharContainer(guessChar: GuessChar, currentGuess: Boolean, currentChar: Boolean) {

    Box(
        modifier = Modifier
            .size(48.dp)
            .background(
                color = when {
                    guessChar.status == CheckCharEnum.CHAR_IN_PLACE -> colorResource(id = R.color.BudGreen)
                    guessChar.status == CheckCharEnum.CHAR_OUT_OF_PLACE -> colorResource(id = R.color.Fawn)
                    guessChar.status == CheckCharEnum.WRONG_CHAR -> colorResource(id = R.color.BattleshipGrey)
                    currentGuess -> Color.LightGray
                    else -> Color.White
                },
                shape = RoundedCornerShape(5.dp)
            )
            .border(
                width = 2.dp,
                color = colorResource(id = R.color.RaisinBlack),
                shape = RoundedCornerShape(5.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = guessChar.char?.toString() ?: "  ",
            style = if (currentChar) MaterialTheme.typography.h4.copy(textDecoration = TextDecoration.Underline) else MaterialTheme.typography.h4,
            color = colorResource(id = R.color.RaisinBlack),
            fontWeight = FontWeight.Bold,
        )
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewCharContainer() {
    CharContainer(guessChar = GuessChar(status = CheckCharEnum.WRONG_CHAR), currentGuess = true, currentChar = true)
}