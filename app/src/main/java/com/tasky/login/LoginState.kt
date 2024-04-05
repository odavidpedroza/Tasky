package com.tasky.login

import androidx.annotation.StringRes
import com.tasky.R

data class LoginState(
    @StringRes val headerTextId: Int = R.string.welcome_back,
    @StringRes val buttonTextId: Int = R.string.login,
    @StringRes val registerInfoText: Int = R.string.register_info_text,
    @StringRes val registerActionText: Int = R.string.register_action_text,
)