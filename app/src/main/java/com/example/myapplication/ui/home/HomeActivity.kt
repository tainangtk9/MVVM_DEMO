package com.example.myapplication.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLoginBinding
import dagger.hilt.android.scopes.ViewModelScoped

class HomeActivity : AppCompatActivity() {
    val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
//        binding.
    }
}