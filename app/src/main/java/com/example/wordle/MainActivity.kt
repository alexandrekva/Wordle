package com.example.wordle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.wordle.feature_splash_screen.presentation.SplashScreenViewModel
import com.example.wordle.navigation.SetupNavGraph
import com.example.wordle.ui.theme.WordleTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashScreenViewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition{
            splashScreenViewModel.isLoading.value
        }

        setContent {
            WordleTheme {
                val startDestination = splashScreenViewModel.startDestination.value
                val navController = rememberNavController()
                SetupNavGraph(navController = navController, startDestination = startDestination)
            }
        }
    }
}