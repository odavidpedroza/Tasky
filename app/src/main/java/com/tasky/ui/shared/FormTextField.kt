package com.tasky.ui.shared

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.tasky.ui.theme.DarkGray
import com.tasky.ui.theme.LightBlue
import com.tasky.ui.theme.LightGray1
import com.tasky.ui.theme.LightGray2
import com.tasky.ui.theme.Red

@Composable
fun FormTextField(
    modifier: Modifier = Modifier,
    label: String = "",
    requestFocus: Boolean = false,
    textFieldValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    trailingIcon: @Composable () -> Unit = {},
    paddingValues: PaddingValues = PaddingValues(),
    visualTransformation: VisualTransformation = VisualTransformation.None
) {

    val focusRequester = remember { FocusRequester() }

    OutlinedTextField(
        colors = getFormTextFieldColors(),
        trailingIcon = trailingIcon,
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues)
            .height(63.dp)
            .focusRequester(focusRequester),
        value = textFieldValue,
        shape = RoundedCornerShape(10.dp),
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        isError = isError,
        visualTransformation = visualTransformation,
        placeholder = { Text(label) },
        singleLine = true
    )

    if (requestFocus) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}

@Composable
fun getFormTextFieldColors() =
    OutlinedTextFieldDefaults.colors(
        focusedBorderColor = LightBlue,
        unfocusedBorderColor = Color.Transparent,
        errorBorderColor = Red,
        unfocusedContainerColor = LightGray2,
        focusedContainerColor = LightGray2,
        errorContainerColor = LightGray2,
        focusedTextColor = DarkGray,
        unfocusedLabelColor = LightGray1,
        unfocusedPlaceholderColor = LightGray1,
        focusedPlaceholderColor = LightGray1
    )
