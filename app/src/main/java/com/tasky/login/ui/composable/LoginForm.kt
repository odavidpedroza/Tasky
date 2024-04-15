package com.tasky.login.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tasky.login.ui.LoginEvent
import com.tasky.login.ui.LoginState
import com.tasky.shared.EmailTextField
import com.tasky.shared.PasswordTextField

@Composable
fun LoginForm(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit
) {
    Surface {
        Column {
            Spacer(modifier = Modifier.padding(8.dp))
            EmailTextField(
                email = state.email,
                valid = state.isEmailValid,
                onValueChange = { onEvent(LoginEvent.UpdateEmail(it)) },
                requestFocus = true
            )
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordTextField(
                password = state.password,
                visible = state.isPasswordVisible,
                valid = state.isPasswordValid,
                onIconClick = { onEvent(LoginEvent.UpdatePasswordVisibility) },
                onValueChange = { onEvent(LoginEvent.UpdatePassword(it)) },
                shouldValidate = false
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
