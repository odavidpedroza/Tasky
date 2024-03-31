package com.tasky.ui.shared

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.tasky.ui.theme.Green

@Composable
fun EmailTextField(requestFocus: Boolean = false) {

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var isValidEmail by remember { mutableStateOf(isValidEmail("")) }

    FormTextField(
        modifier = Modifier.onFocusChanged {
            isValidEmail = if (!it.isFocused && email.text.isNotEmpty())
                isValidEmail(email.text)
            else
                true
        },
        textFieldValue = email,
        label = "Email address",
        requestFocus = requestFocus,
        isError = !isValidEmail,
        onValueChange = {
            email = it
        },
        paddingValues = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
        trailingIcon = {
            IconButton(
                modifier = Modifier.focusProperties { canFocus = false },
                onClick = { },
            ) {
                if (isValidEmail(email.text)) {
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

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z](.*)(@)(.+)(\\.)(.+)")
    return emailRegex.matches(email)
}