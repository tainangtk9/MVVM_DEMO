package com.example.myapplication.ui.auth

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.repositories.UserRepository
import com.example.myapplication.utils.Coroutines
import com.example.myapplication.utils.toast

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null
    var isShowProgressBar = ObservableBoolean(false)
    var userLiveData = MutableLiveData<User?>()


    fun onLoginButtonClick(view: View) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email and password")
            return
        }
        authListener?.onStarted()
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }

     fun getUserInfo(){
         Coroutines.main {
             val response = UserRepository().getUserInfo()
             userLiveData.value = response.data
         }
     }

}