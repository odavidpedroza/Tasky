package com.tasky.application

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tasky.navigation.Screen
import com.tasky.login.LoginScreenRoot
import com.tasky.register.RegisterScreenRoot

@Composable
fun TaskApplication() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreenRoot(navController = navController)
        }
        composable(route = Screen.Register.route) {
            RegisterScreenRoot(navController = navController)
        }
    }
}