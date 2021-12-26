package com.example.myapplication.network

import com.example.myapplication.data.entities.User
import com.example.myapplication.data.response.BaseResponse

/**
 * @author NangPT
 * created on 25/12/2021
 */
interface APIHelper {

//    suspend fun userLogin(email: String, password: String): Call<LoginResponse>

    suspend fun getUserInfo(): BaseResponse<User>

    suspend fun getUsers(): BaseResponse<List<User>>

}