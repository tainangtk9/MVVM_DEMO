package com.example.myapplication.data.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.network.MyAPI
import com.example.myapplication.utils.DEFAULT_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class UserPagingSource(val apiService: MyAPI) : PagingSource<Int, User>() {

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val page = params.key ?: DEFAULT_PAGE_INDEX
        val response = apiService.getUsers(page, params.loadSize)
        val data: List<User> =
            if (response.data is List<User>) response.data as List<User> else arrayListOf()
        return try {
            LoadResult.Page(
                data,
                prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (response.data?.isEmpty() == true) null else page + 1
            )

        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)

        }
    }
}