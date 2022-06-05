package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.App
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.viewmodel.UserResource
import com.example.cleanarchitecture.viewmodel.UserViewModel
import com.example.cleanarchitecture.viewmodel.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel : UserViewModel by viewModels {factory}
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.appComponent.inject(this)

        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        lifecycleScope.launch{
            viewModel.getUsers()
                .collect{
                    when(it){
                        is UserResource.Success -> {
                            Log.d(TAG, "initViews: ${it.list}")
                        }
                        is UserResource.Error -> {}
                        is UserResource.Loading -> {}
                    }
                }
        }

    }
}