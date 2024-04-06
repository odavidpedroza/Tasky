package com.tasky.login.network.model

data class LoginResponse(
    val token: String,
    private val userId: String,
    private val fullName: String
)