package com.tasky.application

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tasky.navigation.Screen
import com.tasky.login.LoginScreenRoot
import com.tasky.login.LoginViewModel
import com.tasky.navigation.NavigationEvent
import com.tasky.register.RegisterScreenRoot
import com.tasky.register.RegisterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

@Composable
fun TaskApplication() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            val loginViewModel: LoginViewModel = hiltViewModel()

            ObserveAsEvents(loginViewModel.navigationChannel) { event ->
                when (event) {
                    NavigationEvent.Login.NavigateToRegister -> navController.navigate(Screen.Register.route)
                    else -> TODO()
                }
            }

            LoginScreenRoot(viewModel = loginViewModel)
        }
        composable(route = Screen.Register.route) {
            val registerViewModel: RegisterViewModel = hiltViewModel()

            ObserveAsEvents(registerViewModel.navigationChannel) { event ->
                when (event) {
                    NavigationEvent.Register.NavigateUp -> navController.navigateUp()
                    else -> TODO()
                }
            }

            RegisterScreenRoot(viewModel = registerViewModel)
        }
    }


}

@Composable
fun <T> ObserveAsEvents(flow: Flow<T>, onEvent: (T) -> Unit) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(flow, lifecycleOwner.lifecycle) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            withContext(Dispatchers.Main.immediate) {
                flow.collect(onEvent)
            }
        }
    }
}