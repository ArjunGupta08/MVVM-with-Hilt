package com.arjungupta08.hiltmvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arjungupta08.hiltmvvm.model.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase() {
    abstract fun getFakerDao() : FakerDao
}