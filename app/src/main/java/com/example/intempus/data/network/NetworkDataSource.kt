package com.example.intempus.data.network

import com.example.intempus.data.network.model.NetworkDateData
import com.example.intempus.data.network.model.NetworkResponse
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val mockDateAPI: MockDateAPI
) {
    suspend fun getAllDates(): NetworkResponse<NetworkDateData> {
            return mockDateAPI.getAllDates()
    }
}