package com.tasky.login.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue

data class LoginState(
    val email: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val password: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val isError: Boolean = false
)