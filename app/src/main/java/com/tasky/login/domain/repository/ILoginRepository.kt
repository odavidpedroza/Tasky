package com.tasky.login.domain.repository


interface ILoginRepository {
    suspend fun login(email: String, password: String): Result<Unit, LoginError>

    enum class LoginError: Error {
        INVALID_EMAIL_OR_PASSWORD,
        NO_CONNECTION,
        UNKNOWN
    }
}