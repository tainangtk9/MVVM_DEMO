package com.example.myapplication.di.module

import com.example.myapplication.BuildConfig
import com.example.myapplication.network.APIHelper
import com.example.myapplication.network.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author NangPT
 * created on 25/12/2021
 */
@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providerBaseURL() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun providerRetrofitClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, baseURL: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providerAPIService(retrofit: Retrofit): APIService? {
        return retrofit.create(APIService::class.java)
    }

    @Provides
    @Singleton
    fun providerAPIHelper(apiHelper: APIHelper):APIHelper = apiHelper

}