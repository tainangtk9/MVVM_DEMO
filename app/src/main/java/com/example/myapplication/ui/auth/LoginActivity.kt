package com.example.myapplication.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import com.example.myapplication.R
import androidx.activity.viewModels
import com.example.myapplication.data.response.LoginResponse
import com.example.myapplication.database.SharedPreference
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.di.module.AdminPreference
import com.example.myapplication.ui.home.HomeActivity
import com.example.myapplication.ui.home.HomeActivityViewModel
import com.example.myapplication.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *  User and password login
 * "email": "eve.holt@reqres.in",
 * "password": "cityslicka"
 */
@AndroidEntryPoint
class LoginActivity @Inject constructor() : AppCompatActivity(), AuthListener {
    private var binding: ActivityLoginBinding? = null

    private val authViewModel: AuthViewModel by viewModels()

    @Inject
    @AdminPreference
    lateinit var sharedPreference: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding?.authViewModel = authViewModel
        authViewModel.authListener = this
    }

    override fun onSuccess(message: LiveData<LoginResponse?>) {
        message.observe(this) { loginResponse ->
            if (!loginResponse?.token.isNullOrBlank()) {
                getUserInfo()
            } else {
                binding?.authViewModel?.isShowProgressBar?.set(false)
                toast("Login Fail")
            }
        }
    }


    override fun onFailure(message: String) {
        binding?.authViewModel?.isShowProgressBar?.set(false)
        toast(message)
    }

    override fun onStarted() {
        binding?.authViewModel?.isShowProgressBar?.set(true)
    }

    private fun getUserInfo() {
        binding?.authViewModel?.getUserInfo()?.observe(this) { user ->
            if (user != null) {
                sharedPreference.putString(
                    "Name",
                    user.firstName + " " + user.lastName
                )
                binding?.authViewModel?.isShowProgressBar?.set(false)
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}