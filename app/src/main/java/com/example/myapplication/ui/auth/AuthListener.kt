package com.example.myapplication.ui.auth

import androidx.lifecycle.LiveData
import com.example.myapplication.data.response.LoginResponse

interface AuthListener {
    fun onSuccess(message: LiveData<LoginResponse?>)
    fun onFailure(message: String)
    fun onStarted()

}