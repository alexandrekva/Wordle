package com.example.wordle.feature_game.data.local

interface WordsDAO {
    suspend fun getRandomWord(): String
}