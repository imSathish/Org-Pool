package com.example.orgcarpool.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import javax.inject.Inject

class ApiService(private val client: HttpClient) {

    companion object {
        private const val END_POINT =
            ""
    }

    suspend fun getTrips() = client.get(END_POINT)
}
