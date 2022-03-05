package com.example.wordle.feature_game.domain.repository

import kotlinx.coroutines.flow.Flow

interface WordsRepository {
    fun getAllWords(): Flow<List<String>>
}