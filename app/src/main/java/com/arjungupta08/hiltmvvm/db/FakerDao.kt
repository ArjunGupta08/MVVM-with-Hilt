package com.arjungupta08.hiltmvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arjungupta08.hiltmvvm.model.Product

@Dao
interface FakerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(product: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getData() : List<Product>

}