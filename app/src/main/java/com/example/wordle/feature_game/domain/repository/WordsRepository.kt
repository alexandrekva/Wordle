package com.example.wordle.feature_game.domain.repository

import kotlinx.coroutines.flow.Flow

interface WordsRepository {
    fun getRandomWord(): Flow<String>
}