package com.example.orgcarpool.features.dashboard

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.orgcarpool.core.theme.background
import com.example.orgcarpool.data.TripList

@Composable
fun DashboardRoute(
    modifier: Modifier = Modifier,
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {
//    val dashboardViewModel = DashboardViewModel()

    val dashboardUiState by dashboardViewModel.dashboardState.collectAsState()

    DashboardScreen(
        isLoading = dashboardUiState.isLoading
    )
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen(
        isLoading = true
    )
}

@Composable
fun DashboardScreen(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = background)
    ) {
        Row (
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.elevatedCardElevation(10.dp),
                shape = CircleShape
            ) {
                Icon(
                    Icons.Default.Person,
                    tint = Color.Black,
                    contentDescription = "Profile",
                    modifier = Modifier.padding(10.dp)
                )
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.elevatedCardElevation(10.dp),
                shape = CircleShape
            ) {
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        Icons.Default.Notifications,
                        tint = Color.Black,
                        contentDescription = "Notification"
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))

    }
}

@Preview
@Composable
private fun UpComingRideCardComponentPreview() {
    UpComingRideCardComponent(
        tripDetails = TripList.Trip(
            car = "Kia-2024",
            from = "Thambaram",
            to = "Sholinganallur",
            time = "6:00 PM",
            totalSeats = 5,
            remainingSeats = 3,
            owner = "Syed",
            date = "Today",
            filled = false
        )
    )
}

@Composable
fun UpComingRideCardComponent(
    modifier: Modifier = Modifier,
    tripDetails : TripList.Trip
) {
    Card(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = CircleShape
            ) {
                Icon(
                    Icons.Default.LocationOn,
                    tint = Color.Black,
                    contentDescription = "Location",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                )
            }
            Column (
                modifier = Modifier
                    .weight(1f),
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ){
                    Column {
                    Text(
                        text = tripDetails
                    )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CommonLoaderPreview() {
    CommonLoader()
}

@Composable
fun CommonLoader(
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { }
    ) {
        Card {
            CircularProgressIndicator(
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}