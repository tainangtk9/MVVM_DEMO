package com.example.myapplication.network

import com.example.myapplication.data.request.LoginRequest
import com.example.myapplication.data.response.LoginResponse
import retrofit2.Call
import javax.inject.Inject

/**
 * @author NangPT
 * created on 25/12/2021
 */
class APIHelperImpl @Inject constructor(private val apiService: APIService) : APIHelper {
    override fun userLogin(email: String, password: String): Call<LoginResponse> {
        return apiService.userLogin(LoginRequest(email, password))
    }

    override fun getUserInfo() = apiService.getUserInfo()

    override fun getUsers() = apiService.getUsers()
}