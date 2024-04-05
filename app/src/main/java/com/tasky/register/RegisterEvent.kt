package com.tasky.register

sealed class RegisterEvent {
    data object NavigateToCalendar : RegisterEvent()
    data object NavigateUp : RegisterEvent()
}