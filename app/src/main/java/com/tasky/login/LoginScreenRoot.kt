package com.tasky.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tasky.navigation.Screen

@Composable
fun LoginScreenRoot(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    LoginScreen(onEvent = viewModel::onEvent)

    LaunchedEffect(uiState) {
        if (uiState.navigateToRegisterScreen) {
            navController.navigate(Screen.Register.route)
            viewModel.navigationToRegisterScreenComplete()
        }
    }
}