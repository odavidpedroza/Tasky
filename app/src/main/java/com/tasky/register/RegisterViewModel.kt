package com.tasky.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasky.navigation.NavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private var _state = MutableStateFlow(RegisterState())
    var state: StateFlow<RegisterState> = _state.asStateFlow()

    private var _navigationChannel = Channel<NavigationEvent>()
    var navigationChannel = _navigationChannel.receiveAsFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            RegisterEvent.NavigateUp -> navigateUp()
        }
    }

    private fun navigateUp() {
        viewModelScope.launch {
            _navigationChannel.send(NavigationEvent.Register.NavigateUp)
        }
    }
}
