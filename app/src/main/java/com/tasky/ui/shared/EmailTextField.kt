package com.tasky.ui.shared

import android.util.Patterns
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.R
import com.tasky.ui.theme.Green
import com.tasky.ui.theme.Red

@Composable
fun EmailTextField(
    requestFocus: Boolean = false,
    paddingValues: PaddingValues
) {

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var isValidEmail by remember { mutableStateOf(true) }

    /**
     * The email must be a valid email
     */
    fun String.isValidEmail() =
        Patterns.EMAIL_ADDRESS.matcher(this).matches()

    FormTextField(
        modifier = Modifier.onFocusChanged {
            isValidEmail = if (!it.isFocused && email.text.isNotEmpty())
                email.text.isValidEmail()
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
        paddingValues = paddingValues,
        trailingIcon = {
            IconButton(
                modifier = Modifier.focusProperties { canFocus = false },
                onClick = { },
            ) {
                if (email.text.isValidEmail()) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = "valid email icon",
                        tint = Green
                    )
                }
            }
        }
    )
}
