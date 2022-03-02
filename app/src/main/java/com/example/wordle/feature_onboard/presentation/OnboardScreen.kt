package com.example.wordle.feature_onboard.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OnboardScreen() {
    Scaffold(Modifier.fillMaxSize()) {
        Text(text = "OnboardScreen", style = MaterialTheme.typography.h3)
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardScreenPreview() {
    OnboardScreen()
}