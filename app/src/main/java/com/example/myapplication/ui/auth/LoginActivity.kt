package com.example.myapplication.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.network.MyAPI
import com.example.myapplication.data.repositories.UserRepository
import com.example.myapplication.data.response.LoginResponse
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.utils.Coroutines
import com.example.myapplication.utils.toast
import dagger.hilt.android.AndroidEntryPoint

/**
 *  User and password login
 * "email": "eve.holt@reqres.in",
 * "password": "cityslicka"
 */
class LoginActivity : AppCompatActivity(), AuthListener {
    private var binding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        binding?.authViewModel = authViewModel
        authViewModel.authListener = this
        binding?.authViewModel?.userLiveData?.observe(this,{
            binding?.authViewModel?.isShowProgressBar?.set(false)
        })
    }

    override fun onSuccess(message: LiveData<LoginResponse?>) {
        message.observe(this, { loginResponse ->
            if (!loginResponse?.token.isNullOrBlank()) {
                binding?.authViewModel?.getUserInfo()
            } else {
                binding?.authViewModel?.isShowProgressBar?.set(false)
                toast("Login Fail")
            }
        })
    }


    override fun onFailure(message: String) {
        binding?.authViewModel?.isShowProgressBar?.set(false)
        toast(message)
    }

    override fun onStarted() {
        binding?.authViewModel?.isShowProgressBar?.set(true)
    }

    private fun getUserInfo(){
        binding?.authViewModel?.userLiveData?.observe(this,{
            binding?.authViewModel?.isShowProgressBar?.set(false)
            if (it!= null){

            }
        })
    }
}