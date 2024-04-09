package com.tasky.login.ui

import androidx.compose.ui.text.input.TextFieldValue

data class LoginState(
    var email: TextFieldValue = TextFieldValue(""),
    val password: TextFieldValue = TextFieldValue(""),
    val isError: Boolean = false
)