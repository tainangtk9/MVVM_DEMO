package com.example.myapplication.data.network

import com.example.myapplication.data.entities.User
import com.example.myapplication.data.request.LoginRequest
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.data.response.UsersResponse
import com.example.myapplication.data.response.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * A p i service
 *
 * @constructor Create empty A p i service
 */
interface APIService {
    /**
     * User login
     *
     * @param requestBody
     * @return
     */
    @POST("login")
    fun userLogin(
        @Body requestBody: LoginRequest
    ): Call<LoginResponse>


    /**
     * Get user info
     *
     * @return
     */
    @GET("/api/users/2")
    suspend fun getUserInfo(): BaseResponse<User>


    /**
     * Get users
     *
     * @param page
     * @param limit
     * @return
     */
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") limit: Int
    ): UsersResponse

    /**
     * Create instance of retrofit
     */
    companion object {
        private const val BASE_URL = "https://reqres.in/api/"
        operator fun invoke(): APIService {
            // Log request and response, param, body....
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            // HTTClient
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
            return retrofit.create(APIService::class.java)
        }
    }
}