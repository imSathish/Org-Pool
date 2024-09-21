package com.example.orgcarpool.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateTrip(
    @SerialName("car")
    val car: String,
    @SerialName("date")
    val date: String,
    @SerialName("filled")
    val filled: Int,
    @SerialName("from")
    val from: String,
    @SerialName("owner")
    val owner: Int,
    @SerialName("time")
    val time: String,
    @SerialName("to")
    val to: String,
    @SerialName("total_seats")
    val totalSeats: Int
)