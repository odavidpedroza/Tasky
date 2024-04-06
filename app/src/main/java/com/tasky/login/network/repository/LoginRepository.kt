package com.tasky.login.network.repository

import com.tasky.login.network.service.ILoginService
import com.tasky.login.network.model.LoginRequest
import com.tasky.login.network.model.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val service: ILoginService
): ILoginRepository {
    override suspend fun login(request: LoginRequest): LoginResponse? =
        service.login(request).body()
}