package com.tasky.login.ui.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.tasky.ui.theme.Blue
import com.tasky.ui.theme.LightGray1
import com.tasky.ui.theme.LightGray3

@Composable
fun LoginClickableText(
    @StringRes registerInfoText: Int,
    @StringRes registerActionText: Int,
    onClick: (Int) -> Unit
) {
    ClickableText(
        style = TextStyle(textAlign = TextAlign.Center, color = LightGray1),
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = LightGray3)) {
                val text = stringResource(id = registerInfoText)
                append(text)
            }
            append(" ")
            withStyle(style = SpanStyle(color = Blue)) {
                val text = stringResource(id = registerActionText)
                append(text)
            }
        }
    )
}