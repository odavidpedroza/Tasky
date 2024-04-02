package com.tasky.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tasky.ui.theme.TaskyTheme

@Composable
fun BottomButton(text: String) {
    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .height(55.dp), onClick = { TODO("Add onClick behavior") }) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomButtonPreview() {
    TaskyTheme {
        Column {
            BottomButton("Short Text")
            BottomButton("Super Hyper Ultra Mega Big Text")
        }
    }
}