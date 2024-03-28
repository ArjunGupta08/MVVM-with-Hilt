package com.arjungupta08.hiltmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.arjungupta08.hiltmvvm.repository.ProductRepository
import com.arjungupta08.hiltmvvm.viewModel.MVFac
import com.arjungupta08.hiltmvvm.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var factoey: MVFac

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this, factoey) [MainViewModel::class.java]

        mainViewModel.products.observe(this) {
            Log.d("TAG", it.toString())
        }

    }
}