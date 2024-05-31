package com.tasky.register

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.R
import com.tasky.shared.FormTextField
import com.tasky.ui.theme.Green
import com.tasky.ui.theme.Red

@Composable
fun NameTextField(
    name: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onFocusChange: (FocusState) -> Unit,
    valid: Boolean,
    focused: Boolean,
    requestFocus: Boolean
) {

    val displayError = !valid && !focused && name.text.isNotEmpty()

    FormTextField(
        modifier = Modifier.onFocusChanged(onFocusChange),
        textFieldValue = name,
        label = stringResource(id = R.string.name),
        requestFocus = requestFocus,
        isError = displayError,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
        onValueChange = onValueChange,
        supportingText = {
            if (displayError) {
                Text(
                    text = stringResource(id = R.string.name_error),
                    color = Red
                )
            }
        },
        trailingIcon = {
            if (valid) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "valid name icon",
                    tint = Green
                )
            }
        }
    )
}
