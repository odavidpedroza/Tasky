package com.tasky.auth.network.repository

import com.tasky.auth.domain.model.AuthResult

interface IAuthRepository {
    suspend fun authenticate(): AuthResult
}