package com.example.wordle.feature_onboard.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordle.feature_onboard.data.OnboardRepository
import com.example.wordle.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val onboardRepository: OnboardRepository
) : ViewModel() {

    var isLoading = mutableStateOf(true)
        private set

    var startDestination = mutableStateOf(Screens.Onboard.route)
        private set

    init {
        viewModelScope.launch {
            onboardRepository.readOnboardState().collect { completed ->
                startDestination.value =
                    if (completed) Screens.Game.route else Screens.Onboard.route
                isLoading.value = false
            }
        }
    }

    fun setCompleted() {
        viewModelScope.launch {
            onboardRepository.saveOnboardState(true)
        }
    }
}