package com.tasky.login.domain

import kotlinx.coroutines.flow.Flow

interface ILoginUseCase {
    suspend fun login(email: String, password: String): Flow<Boolean>
}