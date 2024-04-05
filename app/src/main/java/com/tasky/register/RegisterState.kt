package com.tasky.register

import androidx.annotation.StringRes
import com.tasky.R

data class RegisterState(
    @StringRes val headerTextId: Int = R.string.create_your_account,
    @StringRes val buttonTextId: Int = R.string.get_started
)