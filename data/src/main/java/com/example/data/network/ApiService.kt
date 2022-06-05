package com.example.data.network

import com.example.domain.models.GithubUser
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers() : Flow<List<GithubUser>>
}