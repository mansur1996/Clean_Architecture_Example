package com.example.domain.repository

import com.example.domain.models.GithubUser
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface UserRepository {

    fun getUsers() : Flow<List<GithubUser>>
}