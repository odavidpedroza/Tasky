package com.tasky.login.ui.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tasky.R
import com.tasky.login.ui.LoginEvent
import com.tasky.login.ui.LoginState
import com.tasky.shared.BottomButton
import com.tasky.shared.RoundedHeader
import com.tasky.ui.theme.Red
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
            LoginForm(
                state = state,
                onEvent = onEvent
            )
            BottomButton(
                textId = R.string.login,
                onClick = {
                    onEvent(
                        LoginEvent.Login(
                            state.email.text,
                            state.password.text
                        )
                    )
                }
            )
            ErrorMessage(errorMessage = state.errorMessage)
            Spacer(Modifier.weight(1f))
            LoginClickableText(
                onClick = { onEvent(LoginEvent.NavigateToRegisterScreen) }
            )
        }
    }
}

@Composable
fun ErrorMessage(@StringRes errorMessage: Int) {
    if (errorMessage != 0) {
        Text(
            text = stringResource(id = errorMessage),
            color = Red,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TaskyTheme {
        LoginScreen(LoginState()) { }
    }
}