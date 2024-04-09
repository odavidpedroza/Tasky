package com.tasky.login.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.tasky.shared.EmailTextField
import com.tasky.shared.PasswordTextField

@Composable
fun LoginForm(
    email: MutableState<TextFieldValue>,
    password: MutableState<TextFieldValue>,
) {
    Surface {
        Column {
            Spacer(modifier = Modifier.padding(8.dp))
            EmailTextField(
                email = email,
                requestFocus = true
            )
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordTextField(
                password = password,
                validatePassword = false
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
