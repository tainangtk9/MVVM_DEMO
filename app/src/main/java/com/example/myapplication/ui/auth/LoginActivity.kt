package com.example.myapplication.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.data.response.LoginResponse
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.ui.home.HomeActivity
import com.example.myapplication.utils.toast


/**
 * Login activity
 *
 * @constructor Create empty Login activity
 */
class LoginActivity : AppCompatActivity(), AuthListener {
    private val authViewModel: AuthViewModel by viewModels()
    private var binding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding?.authViewModel = authViewModel
        authViewModel.authListener = this
        getUserInfo()
    }

    /**
     * override login response
     *  [message] Login response
     */
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

    private fun getUserInfo() {
        binding?.authViewModel?.userLiveData?.observe(this, {
            binding?.authViewModel?.isShowProgressBar?.set(false)
            it?.let {
                //TODO save data to database
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }

        })
    }
}