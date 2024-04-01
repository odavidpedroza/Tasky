package com.tasky.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tasky.R
import com.tasky.ui.shared.RoundedHeaderComposable

@Composable
fun LoginHeader() {
    val text = stringResource(id = R.string.welcome_back)
    RoundedHeaderComposable(text)
}
