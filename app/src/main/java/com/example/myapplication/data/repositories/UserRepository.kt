package com.example.myapplication.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.entities.User
import com.example.myapplication.network.APIHelper
import com.example.myapplication.network.APIService
import com.example.myapplication.data.request.LoginRequest
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.data.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiHelper: APIHelper) {

//    suspend fun userLogin(email: String, password: String): LiveData<LoginResponse?> {
//        val loginResponse = MutableLiveData<LoginResponse?>()
//        apiHelper.userLogin(email, password)
//            .enqueue(object : Callback<LoginResponse> {
//                override fun onResponse(
//                    call: Call<LoginResponse>,
//                    response: Response<LoginResponse>
//                ) {
//                    if (response.isSuccessful && response.code() == 200) {
//                        loginResponse.value = response.body()
//                    } else {
//                        loginResponse.value = null
//                    }
//                }
//
//                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                    loginResponse.postValue(null)
//                }
//
//            })
//        return loginResponse
//    }

    suspend fun getUserInfo(): BaseResponse<User> {
        return apiHelper.getUserInfo()
    }
}