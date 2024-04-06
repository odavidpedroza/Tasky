package com.tasky.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasky.auth.domain.usecase.IAuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: IAuthUseCase
) : ViewModel() {

    private val _destinationScreen = MutableStateFlow("")
    val destinationScreen = _destinationScreen.asStateFlow()

    fun authenticate() {
        viewModelScope.launch {
            useCase.authenticate().collect { result ->
                val destination = result.destinationScreen
                _destinationScreen.tryEmit(destination.route)
            }
        }
    }
}
