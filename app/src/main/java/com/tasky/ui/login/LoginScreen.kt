package com.tasky.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tasky.ui.theme.TaskyTheme

@Composable
fun LoginScreen(navController: NavController = rememberNavController()) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            LoginHeader()
            LoginForm()
            LoginButton()
            Spacer(Modifier.weight(1f))
            LoginClickableText(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    TaskyTheme {
        LoginScreen()
    }
}