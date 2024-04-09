package com.tasky.register

import androidx.compose.ui.text.input.TextFieldValue

data class RegisterState(
    val name: TextFieldValue = TextFieldValue(""),
    val email: TextFieldValue = TextFieldValue(""),
    val password: TextFieldValue = TextFieldValue(""),
    val isError: Boolean = false
)