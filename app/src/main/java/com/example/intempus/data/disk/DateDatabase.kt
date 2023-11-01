package com.example.intempus.data.disk

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.intempus.data.disk.model.RoomDateData

@Database(entities = [RoomDateData::class], version = 1)
abstract class DateDatabase : RoomDatabase() {
    abstract fun dateDao(): DateDAO
}