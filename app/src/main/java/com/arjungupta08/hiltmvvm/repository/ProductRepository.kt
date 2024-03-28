package com.arjungupta08.hiltmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arjungupta08.hiltmvvm.db.FakerDB
import com.arjungupta08.hiltmvvm.model.Product
import com.arjungupta08.hiltmvvm.retrofit.FakerApi
import javax.inject.Inject

class ProductRepository @Inject constructor(val fakerApi: FakerApi, val fakerDB: FakerDB) {

    private var mutableLiveData = MutableLiveData<List<Product>>()

    val liveData : LiveData<List<Product>>
        get() = mutableLiveData

    suspend fun getProduct() {
        val data = fakerApi.getProducts()
        if (data.isSuccessful && data.body() != null) {
            mutableLiveData.postValue(data.body())
            fakerDB.getFakerDao().insertData(data.body()!!)
        }
    }
}