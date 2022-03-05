package com.example.wordle.feature_game.data.repository

import com.example.wordle.feature_game.data.local.WordsDAO
import com.example.wordle.feature_game.domain.repository.WordsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordsRepositoryImpl(private val wordsDAO: WordsDAO): WordsRepository{
    override fun getRandomWord(): Flow<String> = flow {
        val randomWord = wordsDAO.getRandomWord()
        emit(randomWord)
    }

}