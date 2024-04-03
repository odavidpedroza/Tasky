package com.tasky.register

sealed class RegisterEvent {
    data object NavigateUp : RegisterEvent()
    data object NavigateUpDone : RegisterEvent()
}