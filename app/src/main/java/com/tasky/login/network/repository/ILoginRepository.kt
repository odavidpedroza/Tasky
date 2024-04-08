package com.tasky.login.network.repository

import com.tasky.login.network.model.LoginRequest
import com.tasky.login.network.model.LoginResponse

interface ILoginRepository {
    suspend fun login(request: LoginRequest): LoginResponse?
}