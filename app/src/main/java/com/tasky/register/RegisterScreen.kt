package com.tasky.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tasky.shared.BottomButton
import com.tasky.shared.RoundedHeader
import com.tasky.ui.theme.TaskyTheme

@Composable
fun RegisterScreen(
    state: RegisterState,
    onEvent: (RegisterEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            RoundedHeader(
                textId = state.headerTextId
            )
            RegisterForm()
            BottomButton(
                textId = state.buttonTextId,
                onClick = { onEvent(RegisterEvent.NavigateToCalendar) }
            )
            Spacer(Modifier.weight(1f))
            RegisterFloatingActionButton(
                onClick = { onEvent(RegisterEvent.NavigateUp) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    TaskyTheme {
        RegisterScreen(RegisterState()) { }
    }
}