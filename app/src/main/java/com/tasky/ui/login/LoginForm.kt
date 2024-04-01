package com.tasky.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tasky.ui.shared.EmailTextField
import com.tasky.ui.shared.PasswordTextField

@Composable
fun LoginForm() {
    Surface {
        Column {
            EmailTextField(requestFocus = true, PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp))
            PasswordTextField(validatePassword = false)
        }
    }
}
