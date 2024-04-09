package com.tasky.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasky.auth.network.repository.IAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: IAuthRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _destinationScreen = Channel<String>()
    val destinationScreen = _destinationScreen.receiveAsFlow()

    fun authenticate() {
        viewModelScope.launch {
            val result = repository.authenticate()
            _destinationScreen.send(result.destinationScreen.route)
            _isLoading.emit(false)
        }
    }
}
