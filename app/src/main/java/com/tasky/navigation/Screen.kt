package com.tasky.navigation

sealed class Screen(val route: String) {
    data object Agenda: Screen("agenda")
    data object Login: Screen("login")
    data object Register: Screen("register")
}