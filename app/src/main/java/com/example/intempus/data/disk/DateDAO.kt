package com.example.intempus.data.disk

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.intempus.data.disk.model.RoomDateData
import kotlinx.coroutines.flow.Flow

@Dao
interface DateDAO {

    @Query("SELECT * FROM Employee")
    fun getAllDates(): Flow<List<RoomDateData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDate(breeds: List<RoomDateData>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDate(breed: RoomDateData)
}