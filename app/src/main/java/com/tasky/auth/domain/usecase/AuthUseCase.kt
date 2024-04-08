package com.tasky.auth.domain.usecase

import com.tasky.auth.domain.model.AuthResult
import com.tasky.auth.network.repository.IAuthRepository
import com.tasky.navigation.Screen
import com.tasky.session.ISessionManager
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: IAuthRepository,
    private val sessionManager: ISessionManager
) : IAuthUseCase {

    override suspend fun authenticate(): AuthResult =
        if (repository.authenticate()) {
            AuthResult(Screen.Agenda)
        } else {
            sessionManager.clearToken()
            AuthResult(Screen.Login)
        }
}
