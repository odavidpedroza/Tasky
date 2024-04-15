package com.tasky.register

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasky.R
import com.tasky.login.domain.repository.ILoginRepository
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
class RegisterViewModel @Inject constructor() : ViewModel() {

    private var _state = MutableStateFlow(RegisterState())
    var state: StateFlow<RegisterState> = _state.asStateFlow()

    private var _navigationChannel = Channel<NavigationEvent>()
    var navigationChannel = _navigationChannel.receiveAsFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.HideErrorMessage -> hideErrorMessage()
            is RegisterEvent.UpdateName -> updateNameValue(event.name)
            is RegisterEvent.UpdateEmail -> updateEmailValue(event.email)
            is RegisterEvent.UpdatePassword -> updatePasswordValue(event.password)
            is RegisterEvent.UpdatePasswordVisibility -> updatePasswordVisibility()
            is RegisterEvent.ShowErrorMessage -> showErrorMessage(event.error)
            RegisterEvent.NavigateUp -> navigateUp()
        }
    }

    private fun updateNameValue(name: TextFieldValue) {
        viewModelScope.launch {
            _state.update { _state.value.copy(name = name) }
        }
    }

    private fun updateEmailValue(email: TextFieldValue) {
        viewModelScope.launch {
            _state.update { _state.value.copy(email = email) }
        }
    }

    private fun updatePasswordValue(password: TextFieldValue) {
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

    private fun showErrorMessage(error: ILoginRepository.LoginError) {
        val message = when (error) {
            ILoginRepository.LoginError.UNKNOWN -> R.string.generic_error
            ILoginRepository.LoginError.FIELDS_ARE_EMPTY -> R.string.fields_must_not_be_empty
            ILoginRepository.LoginError.NO_CONNECTION -> R.string.no_connection_error
            ILoginRepository.LoginError.INVALID_EMAIL_OR_PASSWORD -> R.string.invalid_email_or_password_error
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

    private fun navigateUp() {
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Register.NavigateUp)
        }
    }
}
