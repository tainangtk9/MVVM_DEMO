package com.example.myapplication.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.data.response.LoginResponse
import com.example.myapplication.network.APIHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiHelper: APIHelper) {

    fun userLogin(email: String, password: String): LiveData<LoginResponse?> {
        val loginResponse = MutableLiveData<LoginResponse?>()
        apiHelper.userLogin(email, password)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful && response.code() == 200) {
                        loginResponse.value = response.body()
                    } else {
                        loginResponse.value = null
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.e(UserRepository::class.java.name, t.message.toString())

                }

            })
        return loginResponse
    }

    fun getUserInfo(): LiveData<User?> {
        val userResponse = MutableLiveData<User?>()
        apiHelper.getUserInfo().enqueue(object : Callback<BaseResponse<User>?> {
            override fun onResponse(
                call: Call<BaseResponse<User>?>,
                response: Response<BaseResponse<User>?>
            ) {
                if (response.isSuccessful && response.code() == 200) {
                    userResponse.value = response.body()?.data
                } else {
                    userResponse.value = null
                }
            }

            override fun onFailure(call: Call<BaseResponse<User>?>, t: Throwable) {
                Log.e(UserRepository::class.java.name, t.message.toString())
            }

        })
        return userResponse
    }
}