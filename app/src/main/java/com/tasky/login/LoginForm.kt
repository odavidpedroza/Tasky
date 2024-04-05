package com.tasky.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tasky.shared.EmailTextField
import com.tasky.shared.PasswordTextField
import com.tasky.ui.theme.TaskyTheme

@Composable
fun LoginForm() {
    Surface {
        Column {
            Spacer(modifier = Modifier.padding(8.dp))
            EmailTextField(requestFocus = true)
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordTextField(validatePassword = false)
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    TaskyTheme {
        LoginForm()
    }
}
