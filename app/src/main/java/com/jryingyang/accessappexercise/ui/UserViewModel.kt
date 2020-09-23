package com.jryingyang.accessappexercise.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.jryingyang.accessappexercise.data.GithubRepository
import com.jryingyang.accessappexercise.model.User
import com.jryingyang.accessappexercise.model.UserDetail

class UserViewModel(private val repository: GithubRepository) : ViewModel() {

    private var currentData: LiveData<PagingData<User>>? = null

    fun getUserList(): LiveData<PagingData<User>> {
        val newData = repository.requestUserList()
        currentData = newData
        return newData
    }

    suspend fun getUserDetail(login: String): UserDetail {
        return repository.requestUserDetail(login)
    }
}