package com.example.myapplication.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHomeBinding
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    private val TAG = HomeActivity::class.java.name
    private val homeViewModel: HomeViewModel by viewModels()
    private var binding: ActivityHomeBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        getUsers()
    }

    private fun getUsers() {
        lifecycleScope.launch {
            homeViewModel.getUsers()
            homeViewModel.userPagingLiveData.observe(this@HomeActivity, {
            })
        }

    }
}