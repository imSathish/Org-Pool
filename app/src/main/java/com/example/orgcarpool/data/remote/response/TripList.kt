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
        @SerialName("filled") val filled: Boolean,
        @SerialName("from") val from: String,
        @SerialName("owner") val owner: String,
        @SerialName("time") val time: String,
        @SerialName("to") val to: String,
        @SerialName("total_seats") val totalSeats: Int,
        @SerialName("remaining_seats") val remainingSeats : Int,
    )
}