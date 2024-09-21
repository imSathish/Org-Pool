package com.example.orgcarpool.data.remote

import com.example.orgcarpool.data.remote.response.TripList
import com.example.orgcarpool.data.remote.response.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post

class ApiService constructor(private val client: HttpClient) {

    companion object {
        private const val END_POINT =
            "https://fd9a-49-249-171-190.ngrok-free.app/"
    }

    suspend fun getTrips(): List<TripList.Trip> = client.get(END_POINT).body()

    suspend fun login(name: String, email: String): User = client.post("$END_POINT/users?name=$name&email=$email").body()
}
