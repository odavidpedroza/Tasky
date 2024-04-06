package com.tasky.login.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.R

data class LoginState(
    val email: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val password: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val isError: Boolean = false,
    @StringRes val headerTextId: Int = R.string.welcome_back,
    @StringRes val buttonTextId: Int = R.string.login,
    @StringRes val registerInfoText: Int = R.string.register_info_text,
    @StringRes val registerActionText: Int = R.string.register_action_text
)