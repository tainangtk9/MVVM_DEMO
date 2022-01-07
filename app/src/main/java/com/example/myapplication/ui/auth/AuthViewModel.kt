package com.example.myapplication.ui.auth

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.repositories.UserRepository
import com.example.myapplication.utils.Coroutines
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    var email: String? = "eve.holt@reqres.in"
    var password: String? = "cityslicka"
    var authListener: AuthListener? = null
    var isShowProgressBar = ObservableBoolean(false)
    var userLiveData = MutableLiveData<User?>()


    fun onLoginButtonClick(view: View) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email and password")
            return
        }
        authListener?.onStarted()
        val loginResponse = userRepository.userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }

     fun getUserInfo(){
         val response = userRepository.getUserInfo()
         userLiveData.value = response.value
     }

}