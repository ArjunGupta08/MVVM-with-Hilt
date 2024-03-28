package com.arjungupta08.hiltmvvm.retrofit

import com.arjungupta08.hiltmvvm.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>

}