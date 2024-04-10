package com.tasky.login.network.repository

import com.tasky.login.network.service.ILoginService
import com.tasky.login.network.model.LoginRequest
import com.tasky.session.ISessionManager
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val service: ILoginService,
    private val sessionManager: ISessionManager
): ILoginRepository {
    override suspend fun login(email: String, password: String): Boolean {
        val request = LoginRequest(email, password)
        val response = service.login(request)
        response.body()?.let {
            sessionManager.saveAuthToken(it.token)
        }
        return response.body() != null
    }
}