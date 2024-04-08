package com.tasky.agenda

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tasky.ui.theme.TaskyTheme

@Composable
fun AgendaScreen() {
    // TODO implement actual screen
    Text(
        text = "Future Agenda Screen",
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun AgendaScreenPreview() {
    TaskyTheme {
        AgendaScreen()
    }
}