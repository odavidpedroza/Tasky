package com.tasky.ui.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tasky.ui.theme.Black

@Composable
fun RegisterFloatingActionButton(navController: NavController) {
    FloatingActionButton(
        containerColor = Black,
        modifier = Modifier.padding(start = 16.dp, bottom = 64.dp),
        onClick = { navController.navigateUp() }) {
        Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, "back button")
    }
}