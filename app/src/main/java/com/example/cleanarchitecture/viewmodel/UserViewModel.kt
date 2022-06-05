package com.example.cleanarchitecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactor.UserInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userInteractor: UserInteractor) : ViewModel() {

    fun getUsers(): StateFlow<UserResource> {
        val stateFlow = MutableStateFlow<UserResource>(UserResource.Loading)
        viewModelScope.launch {
            userInteractor.getUsers()
                .catch {
                    stateFlow.emit(UserResource.Error(it.message ?: ""))
                }
                .collect {
                    if (it.isSuccess) {
                        stateFlow.emit(UserResource.Success(it.getOrNull()))
                    } else if (it.isFailure) {
                        stateFlow.emit(UserResource.Error(it.exceptionOrNull()?.toString()))
                    } else {

                    }
                }
        }
        return stateFlow
    }

}