package com.example.cleanarchitecture.viewmodel

import com.example.domain.models.GithubUser

sealed class UserResource {
    object Loading : UserResource()
    data class Success(val list: List<GithubUser>?) : UserResource()
    data class Error(val message : String?) : UserResource()
}