package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.App
import com.example.cleanarchitecture.di.module.ApplicationModule
import com.example.cleanarchitecture.di.module.DataModule
import com.example.cleanarchitecture.di.module.ViewModelModule
import com.example.cleanarchitecture.presentation.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app: App) : AppComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)

}