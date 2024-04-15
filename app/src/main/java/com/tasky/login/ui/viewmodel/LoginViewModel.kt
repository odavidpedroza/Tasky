package com.tasky.login.ui.viewmodel

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasky.R
import com.tasky.login.domain.repository.ILoginRepository
import com.tasky.login.domain.repository.ILoginRepository.LoginError
import com.tasky.login.ui.LoginEvent
import com.tasky.login.ui.LoginState
import com.tasky.navigation.NavigationEvent
import com.tasky.login.domain.repository.Result.Success
import com.tasky.login.domain.repository.Result.Error
import com.tasky.validator.UserDataValidator.isValidEmail
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
            is LoginEvent.HideErrorMessage -> hideErrorMessage()
            is LoginEvent.Login -> login(event.email, event.password)
            is LoginEvent.UpdateEmail -> updateEmailValue(event.email)
            is LoginEvent.ShowErrorMessage -> showErrorMessage(event.error)
            is LoginEvent.UpdatePassword -> updatePasswordValue(event.password)
            is LoginEvent.UpdatePasswordVisibility -> updatePasswordVisibility()
            LoginEvent.NavigateToRegisterScreen -> navigateToRegisterScreen()
        }
    }

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            showErrorMessage(LoginError.FIELDS_ARE_EMPTY)
            return
        }
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
                _state.value.copy(
                    email = email,
                    isEmailValid = isValidEmail(email.text)
                )
            }
        }
    }

    private fun updatePasswordValue(password: TextFieldValue) {
        hideErrorMessage()
        viewModelScope.launch {
            _state.update { _state.value.copy(password = password) }
        }
    }

    private fun updatePasswordVisibility() {
        hideErrorMessage()
        viewModelScope.launch {
            val updatedValue = !_state.value.isPasswordVisible
            _state.update { _state.value.copy(isPasswordVisible = updatedValue) }
        }
    }

    private fun navigateToRegisterScreen() {
        hideErrorMessage()
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Login.NavigateToRegister)
        }
    }

    private fun navigateToAgendaScreen() {
        hideErrorMessage()
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Login.NavigateToAgenda)
        }
    }

    private fun showErrorMessage(error: LoginError) {
        val message = when (error) {
            LoginError.UNKNOWN -> R.string.generic_error
            LoginError.FIELDS_ARE_EMPTY -> R.string.fields_must_not_be_empty
            LoginError.NO_CONNECTION -> R.string.no_connection_error
            LoginError.INVALID_EMAIL_OR_PASSWORD -> R.string.invalid_email_or_password_error
        }
        viewModelScope.launch {
            _state.update {
                _state.value.copy(errorMessage = message)
            }
        }
    }

    private fun hideErrorMessage() {
        viewModelScope.launch {
            _state.update {
                _state.value.copy(errorMessage = 0)
            }
        }
    }
}
