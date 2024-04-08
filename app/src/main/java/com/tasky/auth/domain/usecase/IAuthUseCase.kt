package com.tasky.auth.domain.usecase

import com.tasky.auth.domain.model.AuthResult

interface IAuthUseCase {
    suspend fun authenticate(): AuthResult
}
