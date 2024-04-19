package com.tasky.login.ui

import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.login.domain.repository.ILoginRepository.LoginError

sealed class LoginEvent {
    data object ShowLoading : LoginEvent()
    data object HideLoading : LoginEvent()
    data class Login(val email: String, val password: String) : LoginEvent()
    data class UpdateEmail(val email: TextFieldValue) : LoginEvent()
    data class UpdatePassword(val password: TextFieldValue) : LoginEvent()
    data object UpdatePasswordVisibility : LoginEvent()
    data class ShowErrorMessage(val error: LoginError) : LoginEvent()
    data object HideErrorMessage : LoginEvent()
    data object NavigateToRegisterScreen : LoginEvent()
}