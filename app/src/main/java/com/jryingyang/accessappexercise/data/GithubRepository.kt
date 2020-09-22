package com.jryingyang.accessappexercise.data

import android.util.Log
import com.jryingyang.accessappexercise.api.GithubService
import com.jryingyang.accessappexercise.api.UserResponse

class GithubRepository(private val githubService: GithubService) {

    companion object {
        private val TAG = GithubRepository::class.java.name
    }

    suspend fun requestUserList(): List<UserResponse> {
        val response = githubService.getUserList()
        Log.d(TAG, "response= $response")
        return response
    }
}