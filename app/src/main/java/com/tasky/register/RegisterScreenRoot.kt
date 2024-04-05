package com.tasky.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun RegisterScreenRoot(viewModel: RegisterViewModel) {

    val state by viewModel.state.collectAsState()

    RegisterScreen(onEvent = viewModel::onEvent, state = state)
}