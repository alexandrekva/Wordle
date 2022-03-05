package com.example.wordle.feature_splash_screen.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordle.core.data.PreferencesRepository
import com.example.wordle.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) : ViewModel() {

    var isLoading = mutableStateOf(true)
        private set

    var startDestination = mutableStateOf(Screens.Onboard.route)
        private set

    init {
        viewModelScope.launch {
            preferencesRepository.readOnboardState().collect { completed ->
                startDestination.value =
                    if (completed) Screens.Game.route else Screens.Onboard.route
                isLoading.value = false
            }
        }
    }
}