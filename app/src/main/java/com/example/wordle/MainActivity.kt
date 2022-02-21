package com.example.wordle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.wordle.feature_game.presentation.GameScreen
import com.example.wordle.feature_game.presentation.GameViewModel

class MainActivity : ComponentActivity() {

    private val gameViewModel by viewModels<GameViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameScreen(gameViewModel)
        }
    }
}