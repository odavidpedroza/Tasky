package com.tasky.register

import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.login.domain.repository.ILoginRepository

sealed class RegisterEvent {
    data class Register(val name: String, val email: String, val password: String) : RegisterEvent()
    data class UpdateNameText(val name: TextFieldValue) : RegisterEvent()
    data class UpdateNameFocus(val focused: Boolean) : RegisterEvent()
    data class UpdateEmailText(val email: TextFieldValue) : RegisterEvent()
    data class UpdateEmailFocus(val focused: Boolean) : RegisterEvent()
    data class UpdatePasswordText(val password: TextFieldValue) : RegisterEvent()
    data object UpdatePasswordVisibility : RegisterEvent()
    data class ShowErrorMessage(val error: ILoginRepository.LoginError) : RegisterEvent()
    data object HideErrorMessage : RegisterEvent()
    data object NavigateUp : RegisterEvent()
}