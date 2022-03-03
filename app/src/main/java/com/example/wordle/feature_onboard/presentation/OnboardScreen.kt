package com.example.wordle.feature_onboard.presentation

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.wordle.navigation.Screens

@Composable
fun OnboardScreen(
    navController: NavHostController,
    onboardViewModel: OnboardViewModel = hiltViewModel()
) {
    Scaffold(Modifier.fillMaxSize()) {
        Column() {
            Text(text = "OnboardScreen", style = MaterialTheme.typography.h3)
            Button(onClick = {
                onboardViewModel.setCompleted()
                navController.popBackStack()
                navController.navigate(Screens.Game.route)
            }) {
            }
        }
    }
}