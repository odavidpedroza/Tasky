package com.tasky.auth.network.repository


interface IAuthRepository {
    suspend fun authenticate(): Boolean
}