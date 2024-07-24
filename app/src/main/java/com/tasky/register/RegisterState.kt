package com.tasky.register

import androidx.annotation.StringRes
import androidx.compose.ui.text.input.TextFieldValue

data class RegisterState(
    val name: TextFieldValue = TextFieldValue(""),
    val email: TextFieldValue = TextFieldValue(""),
    val password: TextFieldValue = TextFieldValue(""),
    val isNameValid: Boolean = false,
    val isNameFocused: Boolean = false,
    val isEmailValid: Boolean = false,
    val isEmailFocused: Boolean = false,
    val isPasswordValid: Boolean = false,
    val isPasswordVisible: Boolean = false,
    @StringRes val errorMessage: Int = 0
)