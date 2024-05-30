package com.tasky.login.ui.viewmodel

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasky.R
import com.tasky.login.domain.repository.ILoginRepository
import com.tasky.login.domain.repository.ILoginRepository.LoginError
import com.tasky.login.domain.repository.Result.Error
import com.tasky.login.domain.repository.Result.Success
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

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Login -> login(event.email, event.password)
            is LoginEvent.UpdateEmail -> updateEmailValue(event.email)
            is LoginEvent.UpdatePassword -> updatePasswordValue(event.password)
            is LoginEvent.ShowErrorMessage -> showErrorMessage(event.error)
            LoginEvent.UpdatePasswordVisibility -> updatePasswordVisibility()
            LoginEvent.HideErrorMessage -> hideErrorMessage()
            LoginEvent.ShowLoading -> showLoading()
            LoginEvent.HideLoading -> hideLoading()
            LoginEvent.NavigateToRegisterScreen -> navigateToRegisterScreen()
        }
    }

    fun login(email: String, password: String) {
        hideErrorMessage()
        viewModelScope.launch {
            when (val result = repository.login(email, password)) {
                is Success -> navigateToAgendaScreen()
                is Error -> showErrorMessage(result.error)
            }
        }
    }

    private fun updateEmailValue(email: TextFieldValue) {
        hideErrorMessage()
        viewModelScope.launch {
            _state.update {
                it.copy(email = email)
            }
        }
    }

    private fun updatePasswordValue(password: TextFieldValue) {
        hideErrorMessage()
        viewModelScope.launch {
            _state.update {
                it.copy(password = password)
            }
        }
    }

    private fun updatePasswordVisibility() {
        hideErrorMessage()
        viewModelScope.launch {
            val updatedValue = !_state.value.isPasswordVisible
            _state.update {
                it.copy(isPasswordVisible = updatedValue)
            }
        }
    }

    private fun showLoading() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
        }
    }

    private fun hideLoading() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }

    private fun navigateToRegisterScreen() {
        hideLoading()
        hideErrorMessage()
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Login.NavigateToRegister)
        }
    }

    private fun navigateToAgendaScreen() {
        hideLoading()
        hideErrorMessage()
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Login.NavigateToAgenda)
        }
    }

    private fun showErrorMessage(error: LoginError) {
        hideLoading()
        val message = when (error) {
            LoginError.UNKNOWN -> R.string.generic_error
            LoginError.NO_CONNECTION -> R.string.no_connection_error
            LoginError.INVALID_EMAIL_OR_PASSWORD -> R.string.invalid_email_or_password_error
        }
        viewModelScope.launch {
            _state.update {
                it.copy(errorMessage = message)
            }
        }
    }

    private fun hideErrorMessage() {
        viewModelScope.launch {
            _state.update {
                it.copy(errorMessage = 0)
            }
        }
    }
}
