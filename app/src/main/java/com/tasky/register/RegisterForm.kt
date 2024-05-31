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
                valid = state.isNameValid,
                onValueChange = { onEvent(RegisterEvent.UpdateName(it)) },
                requestFocus = true
            )
            Spacer(modifier = Modifier.padding(4.dp))
            EmailTextField(
                email = state.email,
                valid = state.isEmailValid,
                focused = state.isEmailFocused,
                onValueChange = { onEvent(RegisterEvent.UpdateEmail(it)) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordTextField(
                password = state.password,
                visible = state.isPasswordVisible,
                valid = state.isPasswordValid,
                onValueChange = { onEvent(RegisterEvent.UpdatePassword(it)) },
                onIconClick = { onEvent(RegisterEvent.UpdatePasswordVisibility) },
                shouldValidate = true
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
