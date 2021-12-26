package com.example.myapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.repositories.HomeRepository
import com.example.myapplication.utils.Coroutines
import javax.inject.Inject

/**
 * @author NangPT
 * created on 25/12/2021
 */
class HomeActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    var usersLiveData = MutableLiveData<List<User?>>()

    fun getUsers() {
        Coroutines.main {
            val usersResponse = homeRepository.getUser()
            usersLiveData.value = usersResponse.data
        }
    }

}