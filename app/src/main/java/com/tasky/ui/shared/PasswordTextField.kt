package com.tasky.ui.shared

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tasky.ui.theme.LightGray3
import com.tasky.ui.theme.Red

@Composable
fun PasswordTextField(validatePassword: Boolean) {
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisibility by remember { mutableStateOf(false) }
    var isPasswordValid by remember { mutableStateOf(true) }

    FormTextField(
        textFieldValue = password,
        label = "Password",
        onValueChange = { value: TextFieldValue ->
            password = value
            isPasswordValid = isValidPassword(password.text)
        },
        isError = if (validatePassword) !isValidPassword(password.text) else false,
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibility = !passwordVisibility
                },
                colors = IconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = LightGray3,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color(0xFFBEBEBE),
                )
            ) {
                if (passwordVisibility) {
                    Icon(Icons.Filled.Visibility, "password visibility enabled")
                } else {
                    Icon(Icons.Filled.VisibilityOff, "password visibility disabled")
                }
            }
        },
        paddingValues = PaddingValues(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    )

    if (!isPasswordValid && validatePassword) {
        Text(
            text = "Password needs lowercase and uppercase letters plus at least one digit",
            color = Red,
            style = TextStyle(fontSize = 11.sp),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

fun isValidPassword(password: String): Boolean {
    if (password.length < 2) return true
    var char: Char
    var capitalFlag = false
    var lowerCaseFlag = false
    var numberFlag = false
    for (i in password.indices) {
        char = password[i]
        if (Character.isDigit(char)) {
            numberFlag = true
        } else if (Character.isUpperCase(char)) {
            capitalFlag = true
        } else if (Character.isLowerCase(char)) {
            lowerCaseFlag = true
        }
        if (numberFlag && capitalFlag && lowerCaseFlag) return true
    }
    return false
}
