package com.tasky.login

sealed class LoginEvent {
    data object NavigateToRegisterScreen : LoginEvent()
    data object NavigationToRegisterScreenDone : LoginEvent()
}