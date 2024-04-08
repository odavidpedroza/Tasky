package com.tasky.login.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasky.login.domain.ILoginUseCase
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
    private val useCase: ILoginUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(LoginState())
    var state: StateFlow<LoginState> = _state.asStateFlow()

    private var _navigationChannel = Channel<NavigationEvent>()
    var navigationChannel = _navigationChannel.receiveAsFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            useCase.login(email, password).collect { isLoginSuccessful ->
                if (isLoginSuccessful) {
                    _navigationChannel.send(NavigationEvent.Login.NavigateToAgenda)
                } else {
                    _state.update {
                        _state.value.copy(isError = true)
                    }
                }
            }
        }
    }

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Login -> login(event.email, event.password)
            LoginEvent.NavigateToRegisterScreen -> navigateToRegisterScreen()
        }
    }

    private fun navigateToRegisterScreen() {
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Login.NavigateToRegister)
        }
    }
}
