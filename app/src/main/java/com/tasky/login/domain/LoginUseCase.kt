package com.tasky.login.domain

import com.tasky.login.network.model.LoginRequest
import com.tasky.login.network.repository.ILoginRepository
import com.tasky.session.ISessionManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: ILoginRepository,
    private val sessionManager: ISessionManager
): ILoginUseCase {

    override suspend fun login(email: String, password: String): Flow<Boolean> {
        val response = repository.login(LoginRequest(email, password))
        response?.let {
            sessionManager.saveAuthToken(it.token)
        }
        return flowOf(response != null)
    }
}