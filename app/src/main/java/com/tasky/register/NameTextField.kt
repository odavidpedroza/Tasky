package com.tasky.register

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import com.tasky.R
import com.tasky.shared.FormTextField
import com.tasky.ui.theme.Green
import com.tasky.ui.theme.Red
import com.tasky.validator.UserDataValidator.isValidName

@Composable
fun NameTextField(
    name: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    valid: Boolean,
    requestFocus: Boolean
) {

    FormTextField(

        textFieldValue = name,
        label = stringResource(id = R.string.name),
        requestFocus = requestFocus,
        isError = !valid,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
        onValueChange = onValueChange,
        supportingText = {
            if (!valid) {
                Text(
                    text = stringResource(id = R.string.name_error),
                    color = Red
                )
            }
        },
        trailingIcon = {
            if (isValidName(name.text)) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "valid name icon",
                    tint = Green
                )
            }
        }
    )
}
