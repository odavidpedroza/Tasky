package com.tasky.auth.network.repository

import com.tasky.auth.network.service.IAuthService
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val service: IAuthService
): IAuthRepository {

    override suspend fun authenticate()  =
        service.authenticate().isSuccessful
}
