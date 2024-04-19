package com.tasky.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.R
import com.tasky.ui.theme.Green
import com.tasky.ui.theme.Red

@Composable
fun EmailTextField(
    email: TextFieldValue,
    valid: Boolean,
    onValueChange: (TextFieldValue) -> Unit,
    requestFocus: Boolean = false
) {

    FormTextField(
        textFieldValue = email,
        label = stringResource(id = R.string.email),
        requestFocus = requestFocus,
        isError = !valid && email.text.length > 3,
        onValueChange = onValueChange,
        supportingText = {
            if (!valid && email.text.length > 3) {
                Text(
                    text = stringResource(id = R.string.email_error),
                    color = Red
                )
            }
        },
        trailingIcon = {
            if (valid && email.text.length > 3) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "valid email icon",
                    tint = Green
                )
            }
        }
    )
}
