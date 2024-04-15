package com.tasky.login.domain.repository

import com.tasky.login.domain.repository.ILoginRepository.LoginError
import com.tasky.login.network.model.LoginRequest
import com.tasky.login.network.service.ILoginService
import com.tasky.session.ISessionManager
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val service: ILoginService,
    private val sessionManager: ISessionManager
) : ILoginRepository {
    override suspend fun login(email: String, password: String): Result<Unit, LoginError> {
        val request = LoginRequest(email, password)
        try {
            val response = service.login(request)
            response.body()?.let {
                sessionManager.saveAuthToken(it.token)
                return Result.Success(data = Unit)
            }
            val error = when (response.code()) {
                409 -> LoginError.INVALID_EMAIL_OR_PASSWORD
                else -> LoginError.UNKNOWN
            }
            return Result.Error(error)
        } catch (error: Throwable) {
            return Result.Error(LoginError.NO_CONNECTION)
        }
    }
}
