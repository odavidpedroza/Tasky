package com.tasky.ui.register

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.tasky.R
import com.tasky.ui.shared.FormTextField
import com.tasky.ui.theme.Green
import com.tasky.ui.theme.Red

@Composable
fun NameTextField(requestFocus: Boolean) {

    var name by remember { mutableStateOf(TextFieldValue("")) }
    var isValidName by remember { mutableStateOf(true) }

    /**
     * The full name must be between 4 and 50 characters
     */
    fun String.isValidName() = length in 4..50

    FormTextField(
        modifier = Modifier.onFocusChanged {
            isValidName = if (!it.isFocused && name.text.isNotEmpty())
                name.text.isValidName()
            else
                true
        },
        textFieldValue = name,
        label = stringResource(id = R.string.name),
        requestFocus = requestFocus,
        isError = !isValidName,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
        onValueChange = { value: TextFieldValue ->
            name = value
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
            IconButton(
                modifier = Modifier.focusProperties { canFocus = false },
                onClick = { },
            ) {
                if (name.text.isValidName()) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = "valid name icon",
                        tint = Green
                    )
                }
            }
        },
        paddingValues = PaddingValues(top = 16.dp, start = 16.dp, end = 16.dp)
    )
}
