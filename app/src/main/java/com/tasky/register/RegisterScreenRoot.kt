package com.tasky.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegisterScreenRoot(
    navController: NavHostController,
    viewModel: RegisterViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    RegisterScreen(onEvent = viewModel::onEvent)

    LaunchedEffect(uiState) {
        if (uiState.navigateUp) {
            navController.navigateUp()
            viewModel.onEvent(RegisterEvent.NavigateUpDone)
        }
    }
}