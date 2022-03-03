package com.example.wordle.feature_onboard.di

import android.content.Context
import com.example.wordle.feature_onboard.data.OnboardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardModule {

    @Provides
    @Singleton
    fun provideOnboardRepository(@ApplicationContext context: Context) =
        OnboardRepository(context = context)
}