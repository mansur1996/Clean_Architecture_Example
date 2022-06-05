package com.example.cleanarchitecture.di.module

import com.example.data.network.ApiService
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module(includes = [DataModule.BindModule::class])
class DataModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit : Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    /**
     * Repositorylarni yaratish uchun
     */
    @Module
    abstract class BindModule{
        @Binds
        abstract fun bindApiRepository(userRepositoryImpl: UserRepositoryImpl) : UserRepository
    }

}