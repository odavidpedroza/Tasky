package com.tasky.session

interface ISessionManager {
    fun saveAuthToken(token: String)
    fun fetchAuthToken(): String?
    fun clearToken()
}