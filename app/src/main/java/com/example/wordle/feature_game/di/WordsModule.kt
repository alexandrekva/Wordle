package com.example.wordle.feature_game.di

import com.example.wordle.feature_game.data.local.WordsHardCodedData
import com.example.wordle.feature_game.data.repository.WordsRepositoryImpl
import com.example.wordle.feature_game.domain.repository.WordsRepository
import com.example.wordle.feature_game.domain.use_cases.GetWordList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WordsModule {

    @Provides
    @Singleton
    fun provideWordsHardCodedData(): WordsHardCodedData {
        return WordsHardCodedData()
    }

    @Provides
    @Singleton
    fun provideWordsRepository(wordsHardCodedData: WordsHardCodedData): WordsRepository {
        return WordsRepositoryImpl(wordsHardCodedData)
    }

    @Provides
    @Singleton
    fun provideGetRandomWordUseCase(wordsRepository: WordsRepository) =
        GetWordList(wordsRepository = wordsRepository)


}