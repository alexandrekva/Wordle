package com.example.wordle.feature_game.domain.use_cases

import com.example.wordle.feature_game.domain.repository.WordsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomWordUseCase @Inject constructor(private val wordsRepository: WordsRepository) {
    fun execute(): Flow<String> {
        return wordsRepository.getRandomWord()
    }
}