package com.example.myapplication.di.module

import android.content.Context
import com.example.myapplication.BuildConfig
import com.example.myapplication.database.SharedPreference
import com.example.myapplication.network.APIHelper
import com.example.myapplication.network.APIHelperImpl
import com.example.myapplication.network.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    @AdminPreference
    fun providesAdminPreferName(): String = "admin_Prefer"

    @Provides
    @ClientPreference
    fun providesClientPreferName(): String = "client_Prefer"

    @Provides
    @ClientPreference
    @Singleton
    fun providesClientSharePref(
        @ApplicationContext context: Context,
        @ClientPreference prefer: String
    ): SharedPreference {
        return SharedPreference(context, prefer)
    }

    @Provides
    @AdminPreference
    @Singleton
    fun providesAdminSharePref(
        @ApplicationContext context: Context,
        @AdminPreference prefer: String
    ): SharedPreference {
        return SharedPreference(context, prefer)
    }


}