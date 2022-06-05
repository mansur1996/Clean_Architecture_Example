package com.example.cleanarchitecture.di.module

import com.example.data.network.FlowCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideBaseUrl() : String = "https://api.github.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl : String) : Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(FlowCallAdapterFactory)
            .baseUrl(baseUrl)
            .build()
    }
}