package com.tasky.ui.register

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tasky.R
import com.tasky.ui.shared.BottomButtonComposable

@Composable
fun RegisterButton() {
    val text = stringResource(id = R.string.get_started)
    BottomButtonComposable(text = text)
}