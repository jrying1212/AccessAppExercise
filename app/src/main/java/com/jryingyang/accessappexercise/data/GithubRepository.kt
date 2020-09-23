package com.jryingyang.accessappexercise.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.jryingyang.accessappexercise.api.GithubService
import com.jryingyang.accessappexercise.model.User

class GithubRepository(private val githubService: GithubService) {

    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }

    fun requestUserList(): LiveData<PagingData<User>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { GithubPagingSource(githubService) }
        ).liveData
    }
}