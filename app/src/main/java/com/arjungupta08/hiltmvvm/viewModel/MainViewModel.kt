package com.arjungupta08.hiltmvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjungupta08.hiltmvvm.model.Product
import com.arjungupta08.hiltmvvm.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(val repository : ProductRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }

    val products : LiveData<List<Product>>
        get() = repository.liveData

}