package com.example.intempus.di

import android.content.Context
import androidx.room.Room
import com.example.intempus.data.disk.DateDAO
import com.example.intempus.data.disk.DateDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DiskModule {

    companion object {
        private const val DB_NAME = "date-db"
    }

    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): Context = context

    @Provides
    fun provideDateDao(db: DateDatabase): DateDAO = db.dateDao()


    @Provides
    fun provideDateDatabase(context: Context): DateDatabase {
        return Room.databaseBuilder(context, DateDatabase::class.java, DB_NAME).build()
    }
}