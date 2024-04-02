package com.tasky.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tasky.R
import com.tasky.shared.BottomButton

@Composable
fun LoginButton() {
    val textId = R.string.login
    val text = stringResource(textId)
    BottomButton(text = text)
}