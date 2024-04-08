package com.tasky.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewModelScope
import com.tasky.application.TaskApplication
import com.tasky.ui.theme.TaskyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeStartDestination()
        startSplashScreen()
        viewModel.authenticate()
    }

    private fun startSplashScreen() {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {
            viewModel.isLoading.value
        }
    }

    private fun observeStartDestination() {
        viewModel.viewModelScope.launch {
            viewModel.destinationScreen.collect { destination ->
                if (destination.isNotEmpty())
                    setContent(destination)
            }
        }
    }

    private fun setContent(startDestination: String) {
        setContent {
            TaskyTheme {
                TaskApplication(destination = startDestination)
            }
        }
    }
}