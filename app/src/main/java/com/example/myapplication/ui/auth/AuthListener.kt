package com.example.myapplication.ui.auth

import androidx.lifecycle.LiveData
import com.example.myapplication.data.response.LoginResponse

/**
 * authorize listener
 */
interface AuthListener {
    /**
     * auth success
     * [message] Login response success
     */
    fun onSuccess(message: LiveData<LoginResponse?>)

    /**
     * auth Fail
     *  [message] login response fail
     */
    fun onFailure(message: String)
    fun onStarted()

}