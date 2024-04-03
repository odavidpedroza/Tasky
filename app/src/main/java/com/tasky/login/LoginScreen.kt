package com.tasky.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tasky.ui.theme.TaskyTheme

@Composable
fun LoginScreen(
    onEvent: (LoginEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            LoginHeader()
            LoginForm()
            LoginButton()
            Spacer(Modifier.weight(1f))
            LoginClickableText(
                onClick = {
                    onEvent(LoginEvent.NavigateToRegisterScreen)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TaskyTheme {
        LoginScreen { }
    }
}