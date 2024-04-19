package com.tasky.auth.network.repository

import com.tasky.auth.network.service.IAuthService
import com.tasky.session.ISessionManager
import java.net.UnknownHostException
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val service: IAuthService,
    private val sessionManager: ISessionManager
): IAuthRepository {

    override suspend fun authenticate(): Boolean {
        return try {
            val isAuthenticated = service.authenticate().isSuccessful
            if (!isAuthenticated) {
                sessionManager.clearToken()
            }
            isAuthenticated
        } catch (error: Throwable) {
            val hasAuthToken = !sessionManager.fetchAuthToken().isNullOrBlank()
            val isOffline = error is UnknownHostException
            hasAuthToken && isOffline
        }
    }
}
