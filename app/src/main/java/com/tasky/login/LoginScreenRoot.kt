package com.tasky.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.tasky.coroutines.ObserveAsEvents
import com.tasky.navigation.NavigationEvent
import com.tasky.navigation.Screen

@Composable
fun LoginScreenRoot(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LoginScreen(onEvent = viewModel::onEvent, state = state)

    ObserveAsEvents(viewModel.navigationChannel) { event ->
        when (event) {
            NavigationEvent.Login.NavigateToRegister -> navController.navigate(Screen.Register.route)
            else -> TODO()
        }
    }
}