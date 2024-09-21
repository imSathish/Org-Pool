package com.example.orgcarpool.features.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.orgcarpool.core.theme.background
import com.example.orgcarpool.data.remote.response.TripList
import com.example.orgcarpool.features.create.CreateTripRoute
import kotlinx.coroutines.launch

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
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 3 })
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = background)
    ) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            when (currentPage) {
                0 -> {
                    HomeScreen()
                }

                1 -> {
                    CreateTripRoute()
                }

                2 -> {

                }
            }
        }

        Card(
            modifier = Modifier.padding(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                scope.launch {
                                    pagerState.animateScrollToPage(0)
                                }
                            },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.Home,
                            tint = Color.Black,
                            contentDescription = "Home"
                        )
                        Text(
                            text = "Home",
                            fontWeight = FontWeight.SemiBold,
                        )

                    }
                }


                Card(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                scope.launch {
                                    pagerState.animateScrollToPage(1)
                                }
                            },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.Add,
                            tint = Color.Black,
                            contentDescription = "Home"
                        )
                        Text(
                            text = "Create",
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                }

                Card(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(2)
                        }
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.Person,
                            tint = Color.Black,
                            contentDescription = "Home"
                        )
                        Text(
                            text = "Profile",
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
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

        Text(
            text = "Current Trip :",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier.padding(10.dp)
        )

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
                filled = 2,
                tripName = "Office",
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Upcoming Trip :",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = modifier
            )

            Text(
                text = "See All",
                color = Color(0xFF6191ED)
            )
        }

        LazyColumn {
            items(10) {
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
                        filled = 2,
                        tripName = "Office",
                    )
                )
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
            filled = 2,
            tripName = "Office"
        )
    )
}

@Composable
fun UpComingRideCardComponent(
    currentUser: String = "Syed",
    modifier: Modifier = Modifier,
    tripDetails: TripList.Trip
) {
    Card(
        modifier = Modifier.padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            5.dp
        )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
//            Image(
//                painter = painterResource(R.drawable.ic_map_background),
//                contentDescription = "",
//                modifier = Modifier.matchParentSize(),
//                contentScale = ContentScale.Crop
//            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF6191ED).copy(alpha = .5f)
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
                Column(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = tripDetails.tripName)
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 10.dp)
                            ) {
                                Icon(
                                    Icons.Default.Person,
                                    tint = Color.LightGray,
                                    contentDescription = "",
                                    modifier = Modifier.size(18.dp)
                                )
                                Text(text = currentUser)
                                Box(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .size(5.dp)
                                        .background(color = Color.Black, shape = CircleShape),
                                )
                                Icon(
                                    Icons.Default.LocationOn,
                                    tint = Color.LightGray,
                                    contentDescription = "",
                                    modifier = Modifier.size(18.dp)
                                )
                                Text(
                                    text = tripDetails.to
                                )
                            }
                        }
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF6191ED)
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "${tripDetails.remainingSeats}/${tripDetails.totalSeats} Seats",
                                fontSize = 12.sp,
                                modifier = Modifier.padding(6.dp),
                                color = Color.White
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                    ) {
                        Text(
                            text = "${tripDetails.tripName} . ${tripDetails.time}",
                            // modifier = Modifier.padding(10.dp)
                        )
//                    Box(
//                        modifier = Modifier
//                            .padding(5.dp)
//                            .size(5.dp)
//                            .background(color = Color.Black, shape = CircleShape),
//                    )
//                    Row {
//                        Card(
//                            colors = CardDefaults.cardColors(
//                                containerColor = Color.White
//                            ),
//                            shape = CircleShape
//                        ) {
//                            Icon(
//                                Icons.Default.Person,
//                                tint = Color.Black,
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .size(20.dp)
//                            )
//                        }
//                    }
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