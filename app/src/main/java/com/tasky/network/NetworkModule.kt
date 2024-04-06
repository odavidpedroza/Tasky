package com.tasky.network

import android.content.Context
import com.tasky.auth.network.interceptor.RequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideBaseURL() =
        "https://tasky.pl-coding.com/"

    @Singleton
    @Provides
    fun provideInterceptor(@ApplicationContext context: Context): RequestInterceptor =
        RequestInterceptor(context)

    @Singleton
    @Provides
    fun provideConverterFactory(): Converter.Factory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: RequestInterceptor): OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofitClient(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()
}