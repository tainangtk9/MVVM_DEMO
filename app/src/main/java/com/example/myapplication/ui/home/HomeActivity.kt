package com.example.myapplication.ui.home

import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val TAG = HomeActivityViewModel::class.java.name
    private val homeViewModel: HomeActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeViewModel.getUsers()
        homeViewModel.usersLiveData.observe(this, {
            Log.e(TAG ,"Length"+it.size)
        })
    }


}