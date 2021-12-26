package com.example.myapplication.data.repositories

import com.example.myapplication.data.entities.User
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.network.APIService
import javax.inject.Inject

/**
 * @author NangPT
 * created on 25/12/2021
 */
class HomeRepository @Inject constructor(private val apiService: APIService) {

    suspend fun getUser(): BaseResponse<List<User>> {
        return apiService.getUsers()
    }
}