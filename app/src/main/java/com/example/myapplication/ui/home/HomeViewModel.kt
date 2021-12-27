package com.example.myapplication.ui.home

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.network.MyAPI
import com.example.myapplication.data.repositories.UserRepository
import com.example.myapplication.data.response.UsersResponse
import com.example.myapplication.utils.Coroutines

class HomeViewModel : ViewModel() {
    var isShowProgressBar = ObservableBoolean(false)
    val userPagingLiveData = MutableLiveData<PagingData<User>?>()


    fun getUsers() {
        Coroutines.main {
            val response = UserRepository().getUsers()
            if (response.value != null) {
                userPagingLiveData.value = response.value
            } else {
                userPagingLiveData.value = null
            }
        }

    }
}