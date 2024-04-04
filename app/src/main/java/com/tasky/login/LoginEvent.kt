package com.tasky.login

sealed class LoginEvent {
    data object NavigateToCalendar : LoginEvent()
    data object NavigateToRegisterScreen : LoginEvent()
}