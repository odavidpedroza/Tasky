package com.tasky.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private var _uiState = MutableStateFlow(LoginState())

    var uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.NavigateToRegisterScreen -> navigateToRegisterScreen()
            is LoginEvent.NavigationToRegisterScreenDone -> navigationToRegisterScreenDone()
        }
    }

    private fun navigationToRegisterScreenDone() {
        _uiState.update { it.copy(navigateToRegisterScreen = false) }
    }

    private fun navigateToRegisterScreen() {
        _uiState.update { it.copy(navigateToRegisterScreen = true) }

    }
}

data class LoginState(
    val navigateToRegisterScreen: Boolean = false
)
