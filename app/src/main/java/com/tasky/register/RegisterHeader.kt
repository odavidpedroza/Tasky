package com.tasky.register

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tasky.R
import com.tasky.shared.RoundedHeaderComposable

@Composable
fun RegisterHeader() {
    val text = stringResource(id = R.string.create_your_account)
    RoundedHeaderComposable(text = text)
}
