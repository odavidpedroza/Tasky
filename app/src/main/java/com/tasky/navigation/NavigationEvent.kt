package com.tasky.navigation

sealed class NavigationEvent {
    sealed class Login {
        data object NavigateToRegister : NavigationEvent()
        data object NavigateToCalendar : NavigationEvent()
    }
    sealed class Register {
        data object NavigateUp : NavigationEvent()
        data object NavigateToCalendar : NavigationEvent()
    }
}