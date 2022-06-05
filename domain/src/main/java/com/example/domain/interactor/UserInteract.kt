package com.example.domain.interactor

import com.example.domain.models.GithubUser
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

/**
 * Keladigan ma'lumotni ushlab qandaydir jarayonni amalda bajarish
 */
@Singleton
class UserInteractor @Inject constructor(private val userRepository: UserRepository) {

    fun getUsers() : Flow<Result<List<GithubUser>>>{
        return userRepository.getUsers()
            .map {
                Result.success(it)
            }
            .catch {
                emit(Result.failure(it))
            }
            .flowOn(Dispatchers.IO)
    }
}