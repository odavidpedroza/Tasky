package com.tasky.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.tasky.R
import com.tasky.ui.theme.LightGray3
import com.tasky.ui.theme.Red
import com.tasky.validator.UserDataValidator.isValidPassword

@Composable
fun PasswordTextField(validatePassword: Boolean) {

    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisibility by remember { mutableStateOf(false) }
    var isPasswordValid by remember { mutableStateOf(true) }

    FormTextField(
        textFieldValue = password,
        label = stringResource(id = R.string.password),
        onValueChange = { value: TextFieldValue ->
            password = value
            isPasswordValid = isValidPassword(password.text)
        },
        isError = if (validatePassword && password.text.length > 8) !isValidPassword(password.text) else false,
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        supportingText = {
            if (validatePassword && !isPasswordValid && password.text.isNotEmpty()) {
                Text(
                    text = stringResource(id = R.string.password_error),
                    color = Red
                )
            }
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibility = !passwordVisibility
                },
                colors = IconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = LightGray3,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = LightGray3,
                )
            ) {
                if (passwordVisibility) {
                    Icon(Icons.Filled.Visibility, "password visibility enabled")
                } else {
                    Icon(Icons.Filled.VisibilityOff, "password visibility disabled")
                }
            }
        }
    )
}
