package com.example.intempus.data

import com.example.intempus.data.disk.DiskDataSource
import com.example.intempus.data.disk.model.RoomDateData
import com.example.intempus.data.network.NetworkDataSource
import com.example.intempus.data.network.model.NetworkHttpError
import com.example.intempus.data.network.model.NetworkIOError
import com.example.intempus.data.network.model.NetworkResult
import com.example.intempus.data.presentation.PresentationDateModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject

class DateRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val diskDataSource: DiskDataSource,
) {

    fun observeMostRecentDate(): Flow<PresentationDateModel> {
        return diskDataSource.getAllDates()
            .map { list ->
                try {
                    val mostRecent = list
                        .map { roomItem ->
                            LocalDateTime.parse(roomItem.check_in_date, dateFormatter)
                        }
                        .maxBy {
                            it.toEpochSecond(ZoneOffset.UTC)
                        }
                    val datetimeArray = dateFormatter.format(mostRecent).split(" ")
                    PresentationDateModel(
                        date = datetimeArray[0],
                        time = datetimeArray[1],
                    )

                } catch (e: Exception) {
                    //TODO error handling
                    PresentationDateModel("exception", "exception")
                }
            }
    }

    suspend fun downloadAllDates() = withContext(Dispatchers.IO) {
        when (val response = networkDataSource.getAllDates()) {
            is NetworkResult -> {
                diskDataSource.insertDate(
                    RoomDateData(response.result.check_in_date)
                )
            }
            is NetworkHttpError -> {}
            NetworkIOError -> {}
        }
    }

    suspend fun insertDate(dateTime: String) = withContext(Dispatchers.IO) {
        diskDataSource.insertDate(RoomDateData(dateTime))
    }
}