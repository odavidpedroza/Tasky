package com.tasky.auth.domain.usecase

import com.tasky.auth.domain.model.AuthResult
import kotlinx.coroutines.flow.Flow

interface IAuthUseCase {
    suspend fun authenticate(): Flow<AuthResult>
}
