package com.tasky.auth.network.interceptor

import android.content.Context
import com.tasky.BuildConfig
import com.tasky.session.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context) : Interceptor {
    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sessionManager.fetchAuthToken()?.let { token ->
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        requestBuilder.addHeader("x-api-key", BuildConfig.API_KEY)

        return chain.proceed(requestBuilder.build())
    }
}