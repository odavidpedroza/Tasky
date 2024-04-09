package com.tasky.login.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tasky.R
import com.tasky.login.ui.LoginEvent
import com.tasky.login.ui.LoginState
import com.tasky.shared.BottomButton
import com.tasky.shared.RoundedHeader
import com.tasky.ui.theme.TaskyTheme

@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            RoundedHeader(textId = R.string.welcome_back)
            LoginForm(state.email, state.password)
            BottomButton(
                textId = R.string.login,
                onClick = {
                    onEvent(
                        LoginEvent.Login(
                            state.email.value.text,
                            state.password.value.text
                        )
                    )
                }
            )
            Spacer(Modifier.weight(1f))
            LoginClickableText(
                onClick = { onEvent(LoginEvent.NavigateToRegisterScreen) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TaskyTheme {
        LoginScreen(LoginState()) { }
    }
}