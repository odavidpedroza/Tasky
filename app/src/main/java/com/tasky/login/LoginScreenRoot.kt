package com.tasky.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun LoginScreenRoot(viewModel: LoginViewModel) {

    val state by viewModel.state.collectAsState()

    LoginScreen(onEvent = viewModel::onEvent, state = state)
}