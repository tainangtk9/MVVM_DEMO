package com.example.myapplication.network

import com.example.myapplication.data.entities.User
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.data.response.LoginResponse
import retrofit2.Call
import javax.inject.Inject

/**
 * @author NangPT
 * created on 25/12/2021
 */
class APIHelperImpl @Inject constructor(private val apiService: APIService) : APIHelper {
//    override suspend fun userLogin(email: String, password: String): Call<LoginResponse>{
//        return apiService.userLogin(email,password)
//    }


    override suspend fun getUserInfo() = apiService.getUserInfo()

    override suspend fun getUsers(): BaseResponse<List<User>> = apiService.getUsers()
}