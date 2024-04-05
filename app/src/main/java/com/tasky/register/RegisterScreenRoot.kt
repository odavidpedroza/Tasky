package com.tasky.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.tasky.coroutines.ObserveAsEvents
import com.tasky.navigation.NavigationEvent

@Composable
fun RegisterScreenRoot(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    RegisterScreen(onEvent = viewModel::onEvent, state = state)

    ObserveAsEvents(viewModel.navigationChannel) { event ->
        when (event) {
            NavigationEvent.Register.NavigateUp -> navController.navigateUp()
            else -> TODO()
        }
    }
}