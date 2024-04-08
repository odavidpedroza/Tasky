package com.tasky.login.network.model

data class LoginRequest(
    private val email: String,
    private val password: String
)