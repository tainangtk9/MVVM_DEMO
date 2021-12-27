package com.example.myapplication.data.network

import com.example.myapplication.data.request.LoginRequest
import com.example.myapplication.data.response.UsersResponse
import com.example.myapplication.data.response.LoginResponse
import com.example.myapplication.data.response.UserInfoResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface MyAPI {

    @POST("login")
    fun userLogin(
        @Body requestBody: LoginRequest
    ): Call<LoginResponse>


    @GET("/api/users/2")
    suspend fun getUserInfo(): UserInfoResponse


    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") limit: Int
    ): UsersResponse

    companion object {
        private const val BASE_URL = "https://reqres.in/api/"
        operator fun invoke(): MyAPI {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
            return retrofit.create(MyAPI::class.java)
        }
    }
}