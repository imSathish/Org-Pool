package com.example.orgcarpool.data.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TripList(
    @SerialName("trips") val trips: List<Trip>
) {
    @Serializable
    data class Trip(
        @SerialName("car") val car: String,
        @SerialName("date") val date: String,
        @SerialName("filled") val filled: Int,
        @SerialName("fromDestination") val from: String,
        @SerialName("owner") val owner: String,
        @SerialName("time") val time: String,
        @SerialName("toDestination") val to: String,
        @SerialName("totalSeats") val totalSeats: Int,
        val remainingSeats : Int = totalSeats - filled
    ) {
        var tripName = "Default trip"
    }
}