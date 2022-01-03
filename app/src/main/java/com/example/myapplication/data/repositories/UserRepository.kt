package com.example.myapplication.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.network.APIService
import com.example.myapplication.data.request.LoginRequest
import com.example.myapplication.data.response.BaseResponse
import com.example.myapplication.data.response.LoginResponse
import com.example.myapplication.utils.DEFAULT_PAGE_SIZE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun userLogin(email: String, password: String): LiveData<LoginResponse?> {
        val loginResponse = MutableLiveData<LoginResponse?>()
        val loginRequest = LoginRequest(email, password)
        APIService().userLogin(loginRequest).enqueue(object : Callback<LoginResponse> {
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

    suspend fun getUserInfo(): BaseResponse<User> {
        return APIService().getUserInfo()
    }

    fun getUsers(pagingConfig: PagingConfig = getDefaultPageConfig()): LiveData<PagingData<User>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { UserPagingSource(APIService()) }
        ).liveData
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = true)
    }


}