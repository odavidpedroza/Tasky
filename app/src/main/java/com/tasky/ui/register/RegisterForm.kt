package com.tasky.ui.register

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.tasky.ui.shared.EmailTextField
import com.tasky.ui.shared.PasswordTextField

@Composable
fun RegisterForm() {
    Surface {
        Column {
            NameTextField(requestFocus = true)
            EmailTextField()
            PasswordTextField(validatePassword = true)
        }
    }
}
