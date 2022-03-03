package com.example.wordle.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wordle.feature_game.presentation.GameScreen
import com.example.wordle.feature_onboard.presentation.OnboardScreen

@Composable
fun SetupNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screens.Onboard.route) {
            OnboardScreen(navController = navController)
        }
        composable(route = Screens.Game.route) {
            GameScreen()
        }
    }
}