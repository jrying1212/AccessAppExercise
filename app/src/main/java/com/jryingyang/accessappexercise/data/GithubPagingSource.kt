package com.jryingyang.accessappexercise.data

import androidx.paging.PagingSource
import com.jryingyang.accessappexercise.api.GithubService
import com.jryingyang.accessappexercise.model.User
import retrofit2.HttpException
import java.io.IOException

private const val GITHUB_STARTING_PAGE_INDEX = 0

class GithubPagingSource(private val service: GithubService) : PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val position = params.key ?: GITHUB_STARTING_PAGE_INDEX
        return try {
            val response = service.getUserList(position, params.loadSize)
            LoadResult.Page(
                data = response,
                prevKey = if (position == GITHUB_STARTING_PAGE_INDEX) null else response[response.size - 1].id - 1,
                nextKey = if (response.isEmpty()) null else response[response.size - 1].id
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}