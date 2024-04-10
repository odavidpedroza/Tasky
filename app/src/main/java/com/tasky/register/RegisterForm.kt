package com.tasky.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tasky.shared.EmailTextField
import com.tasky.shared.PasswordTextField

@Composable
fun RegisterForm(
    state: RegisterState,
    onEvent: (RegisterEvent) -> Unit
) {
    Surface {
        Column {
            Spacer(modifier = Modifier.padding(8.dp))
            NameTextField(
                name = state.name,
                onValueChange = { onEvent(RegisterEvent.UpdateName(it)) },
                requestFocus = true
            )
            Spacer(modifier = Modifier.padding(4.dp))
            EmailTextField(
                email = state.email,
                onValueChange = { onEvent(RegisterEvent.UpdateEmail(it)) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordTextField(
                password = state.password,
                onValueChange = { onEvent(RegisterEvent.UpdatePassword(it)) },
                validatePassword = true
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
