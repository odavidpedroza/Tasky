package com.tasky.auth.network.repository

import com.tasky.auth.domain.model.AuthResult
import com.tasky.auth.network.service.IAuthService
import com.tasky.navigation.Screen
import com.tasky.session.ISessionManager
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val service: IAuthService,
    private val sessionManager: ISessionManager
): IAuthRepository {

    override suspend fun authenticate(): AuthResult {
        val isAuthenticated = service.authenticate().isSuccessful
        return if (isAuthenticated) {
            AuthResult(Screen.Agenda)
        } else {
            sessionManager.clearToken()
            AuthResult(Screen.Login)
        }
    }
}
