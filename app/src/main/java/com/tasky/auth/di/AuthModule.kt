package com.tasky.auth.di

import com.tasky.auth.network.repository.AuthRepository
import com.tasky.auth.network.repository.IAuthRepository
import com.tasky.auth.network.service.IAuthService
import com.tasky.session.ISessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Singleton
    @Provides
    fun providesAuthRepository(
        service: IAuthService,
        sessionManager: ISessionManager
    ): IAuthRepository {
        return AuthRepository(service, sessionManager)
    }

    @Singleton
    @Provides
    fun providesAuthService(retrofit: Retrofit): IAuthService =
        retrofit.create(IAuthService::class.java)
}