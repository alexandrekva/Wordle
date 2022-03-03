package com.example.wordle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.wordle.feature_onboard.presentation.OnboardViewModel
import com.example.wordle.navigation.SetupNavGraph
import com.example.wordle.ui.theme.WordleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val onboardViewModel: OnboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            WordleTheme {
                val startDestination = onboardViewModel.startDestination.value
                val navController = rememberNavController()
                SetupNavGraph(navController = navController, startDestination = startDestination)
            }
        }
    }
}