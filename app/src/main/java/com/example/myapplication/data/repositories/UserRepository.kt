package com.example.myapplication.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.request.LoginRequest
import com.example.myapplication.data.network.MyAPI
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.data.response.LoginResponse
import com.example.myapplication.utils.Coroutines
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun userLogin(email: String, password: String): LiveData<LoginResponse?> {
        val loginResponse = MutableLiveData<LoginResponse?>()
        MyAPI().userLogin(LoginRequest(email, password)).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.code() == 200) {
                    loginResponse.value = response.body()
                } else {
                    loginResponse.value = null
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginResponse.postValue(null)
            }

        })
        return loginResponse
    }

    suspend fun getUserInfo(): BaseResponse {
        return MyAPI().getUserInfo()
    }
}