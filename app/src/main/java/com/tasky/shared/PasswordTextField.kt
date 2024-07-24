package com.tasky.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.tasky.R
import com.tasky.ui.theme.Black
import com.tasky.ui.theme.LightGray3
import com.tasky.ui.theme.Red

@Composable
fun PasswordTextField(
    password: TextFieldValue,
    visible: Boolean,
    valid: Boolean,
    validate: Boolean,
    onValueChange: (TextFieldValue) -> Unit,
    onIconClick: () -> Unit
) {

    val displayError = validate && !valid && password.text.isNotEmpty()

    FormTextField(
        textFieldValue = password,
        label = stringResource(id = R.string.password),
        onValueChange = onValueChange,
        isError = if (password.text.length > 7) displayError else false,
        visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
        supportingText = {
            if (displayError) {
                Text(
                    text = stringResource(id = R.string.password_error),
                    color = if (password.text.length < 8) Black else Red
                )
            }
        },
        trailingIcon = {
            IconButton(
                onClick = onIconClick,
                colors = IconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = LightGray3,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = LightGray3,
                )
            ) {
                if (visible) {
                    Icon(Icons.Filled.Visibility, "password visibility enabled")
                } else {
                    Icon(Icons.Filled.VisibilityOff, "password visibility disabled")
                }
            }
        }
    )
}
