package com.tasky.login

import androidx.annotation.StringRes
import com.tasky.R

data class LoginState(
    @StringRes val headerTextId: Int = R.string.welcome_back,
    @StringRes val buttonTextId: Int = R.string.login,
    val linkTextId: Pair<Int, Int> = R.string.sign_up_question to R.string.sign_up
)