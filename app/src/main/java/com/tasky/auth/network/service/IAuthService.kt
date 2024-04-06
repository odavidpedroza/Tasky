package com.tasky.auth.network.service

import retrofit2.Response
import retrofit2.http.GET

interface IAuthService {
    @GET("authenticate")
    suspend fun authenticate(): Response<Unit>
}