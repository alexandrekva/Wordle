package com.example.wordle.feature_onboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordle.core.data.PreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) : ViewModel() {

    fun setCompleted() {
        viewModelScope.launch {
            preferencesRepository.saveOnboardState(true)
        }
    }
}