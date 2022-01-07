package com.example.myapplication.network

import com.example.myapplication.data.entities.User
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.data.response.LoginResponse
import retrofit2.Call

/**
 * @author NangPT
 * created on 25/12/2021
 */
interface APIHelper {

    fun userLogin(email: String, password: String): Call<LoginResponse>

    fun getUserInfo(): Call<BaseResponse<User>?>

    fun getUsers(): Call<BaseResponse<List<User>>?>

}