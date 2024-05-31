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
                focused = state.isNameFocused,
                onValueChange = { onEvent(RegisterEvent.UpdateNameText(it)) },
                onFocusChange = { onEvent(RegisterEvent.UpdateNameFocus(it.isFocused)) },
                requestFocus = true
            )
            Spacer(modifier = Modifier.padding(4.dp))
            EmailTextField(
                email = state.email,
                valid = state.isEmailValid,
                focused = state.isEmailFocused,
                onValueChange = { onEvent(RegisterEvent.UpdateEmailText(it)) },
                onFocusChange = { onEvent(RegisterEvent.UpdateEmailFocus(it.isFocused)) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordTextField(
                password = state.password,
                visible = state.isPasswordVisible,
                valid = state.isPasswordValid,
                onValueChange = { onEvent(RegisterEvent.UpdatePasswordText(it)) },
                onIconClick = { onEvent(RegisterEvent.UpdatePasswordVisibility) },
                shouldValidate = true
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
