package com.tasky.application

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tasky.agenda.AgendaScreen
import com.tasky.navigation.Screen
import com.tasky.login.ui.composable.LoginScreenRoot
import com.tasky.register.RegisterScreenRoot

@Composable
fun TaskApplication(destination: String) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = destination
    ) {
        composable(route = Screen.Agenda.route) {
            AgendaScreen()
        }
        composable(route = Screen.Login.route) {
            LoginScreenRoot(navController = navController)
        }
        composable(route = Screen.Register.route) {
            RegisterScreenRoot(navController = navController)
        }
    }
}
