package com.tasky.navigation

sealed class Screen(val route: String) {
    data object Login: Screen("login")
    data object Register: Screen("register")
}