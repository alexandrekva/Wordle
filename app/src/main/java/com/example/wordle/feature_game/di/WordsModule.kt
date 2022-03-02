package com.example.wordle.feature_game.di

import com.example.wordle.feature_game.data.WordsRepository
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
    fun provideWordsRepository() = WordsRepository()
}