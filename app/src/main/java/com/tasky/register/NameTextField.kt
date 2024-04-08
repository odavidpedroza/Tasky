package com.tasky.register

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
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
    name: MutableState<TextFieldValue>,
    requestFocus: Boolean
) {

    var isValidName by remember { mutableStateOf(true) }

    FormTextField(
        modifier = Modifier.onFocusChanged {
            isValidName = if (!it.isFocused && name.value.text.isNotEmpty())
                isValidName(name.value.text)
            else
                true
        },
        textFieldValue = name.value,
        label = stringResource(id = R.string.name),
        requestFocus = requestFocus,
        isError = !isValidName,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
        onValueChange = { value: TextFieldValue ->
            name.value = value
        },
        supportingText = {
            if (!isValidName) {
                Text(
                    text = stringResource(id = R.string.name_error),
                    color = Red
                )
            }
        },
        trailingIcon = {
            if (isValidName(name.value.text)) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "valid name icon",
                    tint = Green
                )
            }
        }
    )
}
