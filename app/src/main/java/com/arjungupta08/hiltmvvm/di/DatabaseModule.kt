package com.arjungupta08.hiltmvvm.di

import android.content.Context
import androidx.room.Room
import com.arjungupta08.hiltmvvm.db.FakerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context) : FakerDB {
        return Room.databaseBuilder(context, FakerDB::class.java, "FakerDB").build()
    }

}