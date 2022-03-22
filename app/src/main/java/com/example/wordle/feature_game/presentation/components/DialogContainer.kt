package com.example.wordle.feature_game.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.wordle.feature_game.domain.models.GameResultEnum
import com.example.wordle.ui.theme_extensions.spacing

@Composable
fun DialogContainer(resetGame: () -> Unit, resultEnum: GameResultEnum, word: String) {
    Dialog(onDismissRequest = { /*DO NOT DISMISS ON CLICK OUTSIDE DIALOG*/ }) {
        Box(
            Modifier
                .background(
                    color = MaterialTheme.colors.background,
                    shape = MaterialTheme.shapes.large
                )
                .padding(MaterialTheme.spacing.large)
        ) {
            Column {
                val title =
                    if (resultEnum == GameResultEnum.WON) "Parabéns, você ganhou!" else "Que pena, você perdeu!"
                val body =
                    if (resultEnum == GameResultEnum.WON) "Você acertou a palavra $word!" else "A palavra escondida era $word!"
                Text(text = title, style = MaterialTheme.typography.h6)
                Spacer(Modifier.height(MaterialTheme.spacing.medium))
                Text(text = body, style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
                Button(modifier = Modifier.fillMaxWidth(), onClick = { resetGame() }) {
                    Text(text = "Jogar Novamente")
                }
            }
        }
    }
}