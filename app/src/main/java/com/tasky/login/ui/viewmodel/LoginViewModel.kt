package com.tasky.login.ui.viewmodel

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasky.login.network.repository.ILoginRepository
import com.tasky.login.ui.LoginEvent
import com.tasky.login.ui.LoginState
import com.tasky.navigation.NavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: ILoginRepository
) : ViewModel() {

    private var _state = MutableStateFlow(LoginState())
    var state: StateFlow<LoginState> = _state.asStateFlow()

    private var _navigationChannel = Channel<NavigationEvent>()
    var navigationChannel = _navigationChannel.receiveAsFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val isLoginSuccessful = repository.login(email, password)
            if (isLoginSuccessful) {
                navigateToAgendaScreen()
            } else {
                updateErrorValue(true)
            }
        }
    }

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Login -> login(event.email, event.password)
            is LoginEvent.UpdateEmail -> updateEmailValue(event.email)
            is LoginEvent.UpdatePassword -> updatePasswordValue(event.password)
            LoginEvent.NavigateToRegisterScreen -> navigateToRegisterScreen()
        }
    }

    private fun updateErrorValue(isError: Boolean) {
        viewModelScope.launch {
            _state.update {
                _state.value.copy(isError = isError)
            }
        }
    }

    private fun updateEmailValue(email: TextFieldValue) {
        updateErrorValue(false)
        viewModelScope.launch {
            _state.update { _state.value.copy(email = email) }
        }
    }

    private fun updatePasswordValue(password: TextFieldValue) {
        updateErrorValue(false)
        viewModelScope.launch {
            _state.update { _state.value.copy(password = password) }
        }
    }

    private fun navigateToRegisterScreen() {
        updateErrorValue(false)
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Login.NavigateToRegister)
        }
    }

    private fun navigateToAgendaScreen() {
        updateErrorValue(false)
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Login.NavigateToAgenda)
        }
    }
}
