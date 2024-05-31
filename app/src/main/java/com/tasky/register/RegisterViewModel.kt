package com.tasky.register

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasky.R
import com.tasky.login.domain.repository.ILoginRepository
import com.tasky.navigation.NavigationEvent
import com.tasky.validator.UserDataValidator.isValidEmail
import com.tasky.validator.UserDataValidator.isValidName
import com.tasky.validator.UserDataValidator.isValidPassword
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
            is RegisterEvent.UpdateNameText -> updateNameValue(event.name)
            is RegisterEvent.UpdateNameFocus -> updateNameFocus(event.focused)
            is RegisterEvent.UpdateEmailText -> updateEmailValue(event.email)
            is RegisterEvent.UpdateEmailFocus -> updateEmailFocus(event.focused)
            is RegisterEvent.UpdatePasswordText -> updatePasswordValue(event.password)
            is RegisterEvent.UpdatePasswordVisibility -> updatePasswordVisibility()
            is RegisterEvent.ShowErrorMessage -> showErrorMessage(event.error)
            RegisterEvent.NavigateUp -> navigateUp()
        }
    }

    private fun updateNameValue(name: TextFieldValue) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    name = name,
                    isNameValid = isValidName(name.text)
                )
            }
        }
    }

    private fun updateNameFocus(focused: Boolean) {
        hideErrorMessage()
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isNameFocused = focused
                )
            }
        }
    }

    private fun updateEmailValue(email: TextFieldValue) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    email = email,
                    isEmailValid = isValidEmail(email.text)
                )
            }
        }
    }

    private fun updateEmailFocus(focused: Boolean) {
        hideErrorMessage()
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isEmailFocused = focused
                )
            }
        }
    }

    private fun updatePasswordValue(password: TextFieldValue) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    password = password,
                    isPasswordValid = isValidPassword(password.text)
                )
            }
        }
    }

    private fun updatePasswordVisibility() {
        hideErrorMessage()
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isPasswordVisible = !it.isPasswordVisible
                )
            }
        }
    }

    private fun showErrorMessage(error: ILoginRepository.LoginError) {
        val message = when (error) {
            ILoginRepository.LoginError.UNKNOWN -> R.string.generic_error
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
                it.copy(
                    errorMessage = 0
                )
            }
        }
    }

    private fun navigateUp() {
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Register.NavigateUp)
        }
    }
}
