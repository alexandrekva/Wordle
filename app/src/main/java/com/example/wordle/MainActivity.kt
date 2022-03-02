package com.example.wordle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.wordle.navigation.Screens
import com.example.wordle.navigation.SetupNavGraph
import com.example.wordle.ui.theme.WordleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WordleTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController, startDestination = Screens.Onboard.route)
            }
        }
    }
}