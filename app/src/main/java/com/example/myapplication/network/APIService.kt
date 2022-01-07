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
    fun getUserInfo(): Call<BaseResponse<User>?>

    @GET("users")
    fun getUsers(): Call<BaseResponse<List<User>>?>

}