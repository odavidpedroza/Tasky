package com.tasky.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tasky.R
import com.tasky.ui.shared.BottomButtonComposable

@Composable
fun LoginButton() {
    val textId = R.string.login
    val text = stringResource(textId)
    BottomButtonComposable(text = text)
}