package com.tasky.register

import androidx.compose.ui.text.input.TextFieldValue

sealed class RegisterEvent {
    data class UpdateName(val name: TextFieldValue) : RegisterEvent()
    data class UpdateEmail(val email: TextFieldValue) : RegisterEvent()
    data class UpdatePassword(val password: TextFieldValue) : RegisterEvent()
    data object NavigateUp : RegisterEvent()
}