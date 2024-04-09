package com.tasky.login.network.repository


interface ILoginRepository {
    suspend fun login(email: String, password: String): Boolean
}