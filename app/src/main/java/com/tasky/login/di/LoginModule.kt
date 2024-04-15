package com.tasky.login.di

import com.tasky.login.domain.repository.ILoginRepository
import com.tasky.login.domain.repository.LoginRepository
import com.tasky.login.network.service.ILoginService
import com.tasky.session.ISessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Singleton
    @Provides
    fun providesLoginRepository(
        service: ILoginService,
        sessionManager: ISessionManager
    ): ILoginRepository {
        return LoginRepository(service, sessionManager)
    }

    @Singleton
    @Provides
    fun providesLoginService(retrofit: Retrofit): ILoginService =
        retrofit.create(ILoginService::class.java)
}