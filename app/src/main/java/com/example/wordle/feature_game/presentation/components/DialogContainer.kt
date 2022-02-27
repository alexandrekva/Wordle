package com.example.wordle.feature_game.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.wordle.feature_game.domain.models.GameResult

@Composable
fun DialogContainer(resetGame: () -> Unit, result: GameResult) {
    Dialog(onDismissRequest = { /*DO NOT DISMISS ON CLICK OUTSIDE DIALOG*/ }) {
        Box(
            Modifier
                .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                .padding(32.dp)
        ) {
            Column() {
                val resultText = if (result == GameResult.WON) "Parabéns, você adivinhou a palavra!" else "Que pena, você não conseguiu adivinhar a palavra!"
                Text(text = resultText, fontSize = 24.sp)
                Button(onClick = { resetGame() }) {
                    Text(text = "Button")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DialogContainerPreview() {
    DialogContainer({}, GameResult.WON)
}