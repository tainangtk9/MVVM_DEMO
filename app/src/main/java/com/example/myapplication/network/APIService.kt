package com.example.myapplication.network

import com.example.myapplication.data.entities.User
import com.example.myapplication.data.request.LoginRequest
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.data.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface APIService {

    @POST("login")
    fun userLogin(
        @Body requestBody: LoginRequest
    ): Call<LoginResponse>


    @GET("users/2")
    suspend fun getUserInfo(): BaseResponse<User>

    @GET("api/users")
    suspend fun getUsers(): BaseResponse<List<User>>

//    companion object {
//        operator fun invoke(): APIService {
//            val logging = HttpLoggingInterceptor()
//            logging.level = HttpLoggingInterceptor.Level.BODY
//            val httpClient = OkHttpClient.Builder()
//            httpClient.addInterceptor(logging)
//            val retrofit: Retrofit = Retrofit.Builder()
//                .baseUrl(BuildConfig.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
//                .build()
//            return retrofit.create(APIService::class.java)
//        }
//    }
}