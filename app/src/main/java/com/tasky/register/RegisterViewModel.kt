package com.tasky.register

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private var _uiState = MutableStateFlow(RegisterState())
    var uiState: StateFlow<RegisterState> = _uiState.asStateFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.NavigateUp -> navigateUp()
        }
    }

    private fun navigateUp() {
        _uiState.update { it.copy(navigateUp = true)}
    }
}

data class RegisterState(
    val navigateUp: Boolean = false
)