package com.tasky.login.ui

sealed class LoginEvent {
    data class Login(val email: String, val password: String) : LoginEvent()
    data object NavigateToRegisterScreen : LoginEvent()
}