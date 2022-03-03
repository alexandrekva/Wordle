package com.example.wordle.feature_onboard.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "onboard_pref")

class OnboardRepository(context: Context) {

    private val dataStore = context.dataStore

    private object PreferecesKey {
        val onboardKey = booleanPreferencesKey(name = "onboard_completed")
    }

    suspend fun saveOnboardState(completed: Boolean) {
        dataStore.edit { preferences->
            preferences[PreferecesKey.onboardKey] = completed
        }
    }

    fun readOnboardState(): Flow<Boolean> = flow {
        dataStore.data.collect { preferences ->
            val onboardState = preferences[PreferecesKey.onboardKey] ?: false
            emit(onboardState)
        }
    }



}