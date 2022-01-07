package com.example.myapplication.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.network.APIHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * @author NangPT
 * created on 25/12/2021
 */
class HomeRepository @Inject constructor(private val apiHelper: APIHelper) {

    fun getUser(): LiveData<List<User>?> {
        val userList: MutableLiveData<List<User>> = MutableLiveData()
        apiHelper.getUsers().enqueue(object : Callback<BaseResponse<List<User>>?> {
            override fun onResponse(
                call: Call<BaseResponse<List<User>>?>,
                response: Response<BaseResponse<List<User>>?>
            ) {
                userList.value = if (response.isSuccessful) {
                    response.body()?.data
                } else {
                    null
                }
            }

            override fun onFailure(call: Call<BaseResponse<List<User>>?>, t: Throwable) {
                userList.value = null
                Log.e("error", t.message.toString())
            }
        })
        return userList
    }
}