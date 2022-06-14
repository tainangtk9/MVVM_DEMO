package com.example.myapplication.ui.home

import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.database.SharedPreference
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.di.module.AdminPreference
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val TAG = HomeActivityViewModel::class.java.name
    private val homeViewModel: HomeActivityViewModel by viewModels()
    lateinit var binding: ActivityHomeBinding

    @Inject
    @AdminPreference
    lateinit var sharedPreference: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.txtName.text = sharedPreference.getString("Name")
//        homeViewModel.getUsers()
//        homeViewModel.usersLiveData.observe(this) {
//            Log.e(TAG, "Length" + it?.size)
//        }
    }


}