package com.example.myapplication.ui.auth

import android.util.Log
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.repositories.UserRepository
import com.example.myapplication.utils.Coroutines
import com.example.myapplication.utils.toast
import kotlin.math.log

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null
    var isShowProgressBar = ObservableBoolean(false)
    var userLiveData = MutableLiveData<User?>()
    var TAG = AuthViewModel::class.java.canonicalName

    fun validateData(email:String?, password:String? ) {
        //Conditional branch1
        if (email?.isNotEmpty() == true && password?.isNotEmpty() == true) {
            this.email = email
            this.password = password
        } else {
            Log.e(TAG, "Data is invalid" )
            return
        }

        //Conditional branch2
        if (email.contains("@") || password.length >8) {
            login(email,password)
        } else {
            Log.e(TAG, "Data is invalid" )
            return
        }
    }

    fun login(email: String,password: String){
        val loginResponse = UserRepository().userLogin(email, password)
        authListener?.onSuccess(loginResponse)
    }

    fun onLoginButtonClick(view: View) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email and password")
            return
        }
        authListener?.onStarted()
        validateData(email, password)
    }

    fun getUserInfo() {
        Coroutines.main {
            val response = UserRepository().getUserInfo()
            if (response.data != null){
                userLiveData.postValue(response.data)
            }else{
                userLiveData.postValue(null)
            }
        }
    }

}