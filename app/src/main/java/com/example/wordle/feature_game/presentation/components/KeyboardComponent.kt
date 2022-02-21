package com.example.wordle.feature_game.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KeyboardComponent(
    wrongChars: SnapshotStateList<Char>,
    insertChar: (Char) -> Unit,
    deleteChar: () -> Unit,
    checkGuess: () -> Unit
) {
    val upperKeys = listOf('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p')
    val midKeys = listOf('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l')
    val lowKeys = listOf('z', 'x', 'c', 'v', 'b', 'n', 'm')

    val allKeys = listOf(upperKeys, midKeys, lowKeys)

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        for (keyGroup in allKeys) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (key in keyGroup) {
                    Text(
                        modifier = Modifier
                            .size(32.dp)
                            .clickable { insertChar(key) }
                            .background(
                                color = if (wrongChars.contains(key)) Color.DarkGray else Color.Transparent,
                                shape = RoundedCornerShape(5.dp)
                            ),
                        text = key.toString(),
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                    )
                    if (key == 'm') {
                        Box(
                            modifier = Modifier
                                .padding(start = 14.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color.Black,
                                    shape = RoundedCornerShape(2.dp),
                                )
                                .clickable { deleteChar() }, contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                text = "clear",
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { checkGuess() }) { Text(text = "CHECK") }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewKeyboardComponent() {
    val wrongChars = remember { mutableStateListOf('x') }

    KeyboardComponent(
        wrongChars = wrongChars,
        insertChar = {},
        deleteChar = {},
        checkGuess = {})
}