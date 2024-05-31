package com.tasky.auth.network.repository

import com.tasky.auth.network.service.IAuthService
import com.tasky.session.ISessionManager
import java.net.UnknownHostException
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val service: IAuthService,
    private val sessionManager: ISessionManager
) : IAuthRepository {

    override suspend fun authenticate(): Boolean {
        return try {
            val response = service.authenticate()
            val isAuthenticated = response.isSuccessful
            if (!isAuthenticated && response.code() == 401) {
                sessionManager.clearToken()
            }
            isAuthenticated
        } catch (error: UnknownHostException) {
            !sessionManager.fetchAuthToken().isNullOrBlank()
        }
    }
}
