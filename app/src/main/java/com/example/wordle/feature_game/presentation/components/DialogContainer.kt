package com.example.wordle.feature_game.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.wordle.feature_game.domain.models.GameResultEnum

@Composable
fun DialogContainer(resetGame: () -> Unit, resultEnum: GameResultEnum, word: String) {
    Dialog(onDismissRequest = { /*DO NOT DISMISS ON CLICK OUTSIDE DIALOG*/ }) {
        Box(
            Modifier
                .background(color = MaterialTheme.colors.background, shape = RoundedCornerShape(15.dp))
                .padding(32.dp)
        ) {
            Column {
                val title = if (resultEnum == GameResultEnum.WON) "Parabéns, você ganhou!" else "Que pena, você perdeu!"
                val body = if (resultEnum == GameResultEnum.WON) "Você acertou a palavra $word!" else "A palavra escondida era $word!"
                Text(text = title, style = MaterialTheme.typography.h6)
                Spacer(Modifier.height(16.dp))
                Text(text = body, style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(32.dp))
                Button(modifier = Modifier.fillMaxWidth(), onClick = { resetGame() }) {
                    Text(text = "Jogar Novamente")
                }
            }
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DialogContainerPreview() {
    DialogContainer({}, GameResultEnum.WON, "TESTE")
}