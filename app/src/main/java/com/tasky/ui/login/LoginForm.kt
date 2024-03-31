package com.tasky.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.tasky.ui.shared.EmailTextField
import com.tasky.ui.shared.PasswordTextField

@Composable
fun LoginForm() {
    Surface {
        Column {
            EmailTextField(requestFocus = true)
            PasswordTextField(validatePassword = false)
        }
    }
}
