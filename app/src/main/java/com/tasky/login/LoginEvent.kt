package com.tasky.login

sealed class LoginEvent {
    data object NavigateToRegisterScreen : LoginEvent()
}