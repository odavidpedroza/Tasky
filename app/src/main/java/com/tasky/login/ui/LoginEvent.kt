package com.tasky.login.ui

import androidx.compose.ui.text.input.TextFieldValue

sealed class LoginEvent {
    data class Login(val email: String, val password: String) : LoginEvent()
    data class UpdateEmail(val email: TextFieldValue) : LoginEvent()
    data class UpdatePassword(val password: TextFieldValue) : LoginEvent()
    data object NavigateToRegisterScreen : LoginEvent()
}