package com.example.wordle.navigation

sealed class Screens(val route: String) {
    object Onboard : Screens(route = "onboard_screen")
    object Game : Screens(route = "game_screen")
}