package com.tasky.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tasky.shared.EmailTextField
import com.tasky.shared.PasswordTextField

@Composable
fun RegisterForm() {
    Surface {
        Column {
            NameTextField(requestFocus = true)
            EmailTextField(paddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp))
            PasswordTextField(validatePassword = true)
        }
    }
}
