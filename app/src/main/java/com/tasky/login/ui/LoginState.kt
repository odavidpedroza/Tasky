package com.tasky.login.ui

import androidx.annotation.StringRes
import androidx.compose.ui.text.input.TextFieldValue

data class LoginState(
    val email: TextFieldValue = TextFieldValue(""),
    val password: TextFieldValue = TextFieldValue(""),
    val isEmailValid: Boolean = false,
    val isPasswordValid: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    @StringRes val errorMessage: Int = 0
)
