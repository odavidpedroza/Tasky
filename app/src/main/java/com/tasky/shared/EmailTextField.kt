package com.tasky.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.R
import com.tasky.ui.theme.Green
import com.tasky.ui.theme.Red
import com.tasky.validator.UserDataValidator.isValidEmail

@Composable
fun EmailTextField(
    requestFocus: Boolean = false
) {

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var isValidEmail by remember { mutableStateOf(true) }

    FormTextField(
        modifier = Modifier.onFocusChanged {
            isValidEmail = if (!it.isFocused && email.text.isNotEmpty())
                isValidEmail(email.text)
            else true
        },
        textFieldValue = email,
        label = stringResource(id = R.string.email),
        requestFocus = requestFocus,
        isError = !isValidEmail,
        onValueChange = { email = it },
        supportingText = {
            if (!isValidEmail) {
                Text(
                    text = stringResource(id = R.string.email_error),
                    color = Red
                )
            }
        },
        trailingIcon = {
            if (isValidEmail(email.text)) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "valid email icon",
                    tint = Green
                )
            }
        }
    )
}
