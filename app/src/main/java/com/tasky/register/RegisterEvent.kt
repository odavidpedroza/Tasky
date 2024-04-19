package com.tasky.register

import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.login.domain.repository.ILoginRepository

sealed class RegisterEvent {
    data class UpdateName(val name: TextFieldValue) : RegisterEvent()
    data class UpdateEmail(val email: TextFieldValue) : RegisterEvent()
    data class UpdatePassword(val password: TextFieldValue) : RegisterEvent()
    data object UpdatePasswordVisibility : RegisterEvent()
    data class ShowErrorMessage(val error: ILoginRepository.LoginError) : RegisterEvent()
    data object HideErrorMessage : RegisterEvent()
    data object NavigateUp : RegisterEvent()
}