package com.tasky.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.R
import com.tasky.ui.theme.Green
import com.tasky.ui.theme.Red

@Composable
fun EmailTextField(
    email: TextFieldValue,
    valid: Boolean,
    focused: Boolean,
    onFocusChange: (FocusState) -> Unit = {},
    onValueChange: (TextFieldValue) -> Unit,
    requestFocus: Boolean = false
) {

    FormTextField(
        textFieldValue = email,
        label = stringResource(id = R.string.email),
        requestFocus = requestFocus,
        isError = !valid && !focused,
        onValueChange = onValueChange,
        onFocusChange = onFocusChange,
        supportingText = {
            if (!valid && !focused) {
                Text(
                    text = stringResource(id = R.string.email_error),
                    color = Red
                )
            }
        },
        trailingIcon = {
            if (valid) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "valid email icon",
                    tint = Green
                )
            }
        }
    )
}
