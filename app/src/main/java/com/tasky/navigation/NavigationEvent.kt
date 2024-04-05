package com.tasky.navigation

sealed class NavigationEvent {
    sealed class Login {
        data object NavigateToRegister : NavigationEvent()
    }
    sealed class Register {
        data object NavigateUp : NavigationEvent()
    }
}