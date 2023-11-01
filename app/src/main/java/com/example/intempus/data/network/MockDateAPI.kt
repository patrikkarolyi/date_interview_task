package com.example.intempus.data.network

import com.example.intempus.data.dateFormatter
import com.example.intempus.data.network.model.NetworkDateData
import com.example.intempus.data.network.model.NetworkResult
import kotlinx.coroutines.delay
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.LocalTime

class MockDateAPI {

    suspend fun getAllDates(): NetworkResult<NetworkDateData> {
        delay(100)

        //No point parsing it to json but just to match the documentation. Moshi for example solves this issue.
        val date = LocalDateTime.now().with(LocalTime.of(6,30))
        val formattedDate = dateFormatter.format(date)
        val json = JSONObject().put("dateTime",formattedDate)

        return NetworkResult(NetworkDateData(json["dateTime"].toString()))
    }
}