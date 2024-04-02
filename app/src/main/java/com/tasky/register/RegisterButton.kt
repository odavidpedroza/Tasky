package com.tasky.register

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tasky.R
import com.tasky.shared.BottomButton

@Composable
fun RegisterButton() {
    val text = stringResource(id = R.string.get_started)
    BottomButton(text = text)
}