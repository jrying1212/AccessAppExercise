package com.jryingyang.accessappexercise.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jryingyang.accessappexercise.api.UserResponse
import com.jryingyang.accessappexercise.data.GithubRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: GithubRepository) : ViewModel() {

    val listData: MutableLiveData<List<UserResponse>> = MutableLiveData()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            listData.value = repository.requestUserList()
        }
    }
}