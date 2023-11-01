package com.example.intempus.data.disk

import com.example.intempus.data.disk.model.RoomDateData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DiskDataSource @Inject constructor(
    private val dateDAO: DateDAO,
) {
    fun getAllDates(): Flow<List<RoomDateData>> {
        return dateDAO.getAllDates()
    }

    suspend fun insertDate(data: RoomDateData) {
        return dateDAO.insertDate(data)
    }
}