package com.example.myapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.repositories.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author NangPT
 * created on 25/12/2021
 */
@HiltViewModel
class HomeActivityViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {
    var usersLiveData = MutableLiveData<List<User?>?>()

    fun getUsers() {
        usersLiveData.value = homeRepository.getUser().value
    }

}