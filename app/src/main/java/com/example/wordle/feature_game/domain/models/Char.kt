package com.example.wordle.feature_game.domain.models

data class GuessChar(var char: Char? = null, var status: CheckCharEnum? = null)
