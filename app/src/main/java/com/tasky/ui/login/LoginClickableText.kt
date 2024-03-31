package com.tasky.ui.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tasky.navigation.Screen
import com.tasky.ui.theme.Blue
import com.tasky.ui.theme.LightGray1
import com.tasky.ui.theme.LightGray3

@Composable
fun LoginClickableText(navController: NavController) {
    ClickableText(
        style = TextStyle(textAlign = TextAlign.Center, color = LightGray1),
        onClick = {
            navController.navigate(Screen.Register.route)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = LightGray3)) {
                append("DON'T HAVE AN ACCOUNT? ")
            }
            withStyle(style = SpanStyle(color = Blue)) {
                append("SIGN UP")
            }
        }
    )
}