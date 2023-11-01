package com.example.intempus.data.disk.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Employee")
data class RoomDateData(
    @PrimaryKey
    val check_in_date: String, //yyyy-MM-dd HH:mm
)