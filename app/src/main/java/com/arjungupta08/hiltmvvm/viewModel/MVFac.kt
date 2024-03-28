package com.arjungupta08.hiltmvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arjungupta08.hiltmvvm.repository.ProductRepository
import javax.inject.Inject

class MVFac @Inject constructor(val mainViewModel: MainViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mainViewModel as T
    }
}