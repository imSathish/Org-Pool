package com.example.orgcarpool.features.create

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.orgcarpool.R
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun CreateTripRoute(
    modifier: Modifier = Modifier,
    onBackClick : () -> Unit,
    onSaveClick : () -> Unit,
    createTripViewModel: CreateTripViewModel = hiltViewModel()
) {
    CreateTripScreen(
        modifier = modifier,
        onBackClick =  onBackClick,
        onSaveClick = onSaveClick
    )
}

@Preview(showBackground = true)
@Composable
private fun CreateTripScreenPreview() {
    CreateTripScreen(
        onBackClick = {},
        onSaveClick = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTripScreen(
    modifier: Modifier = Modifier,
    background: Color = Color.White,
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
) {
    val context = LocalContext.current
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray),
        topBar = {
            TopAppBar(
                modifier = Modifier.background(background),
                title = {
                    Text(text = "Create Trip")
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    TextButton(onClick = {
                        onSaveClick()
                        Toast.makeText(context,"Trip Added",Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Save", color = Color.Black)
                    }
                }
            )
        },
    ) { paddingValues ->
        Box(modifier = modifier.padding(paddingValues)) {
            CreateTripContent()
        }
    }
}

@Composable
fun CreateTripContent() {
    Column(modifier = Modifier.padding(20.dp)) {
        TripNameCompose()

        DestinationCompose()

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripNameCompose() {
    var tripName by remember { mutableStateOf("Velachery Trip") }
    var isRoundTrip by remember { mutableStateOf(false) }
    var tripDate by remember { mutableStateOf("Friday, Sept 22") }
    var showDatePicker by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .background(color = Color(0xFFEFEFEF), shape = RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Column {
            Text(text = "Name of the trip", fontSize = 18.sp, color = Color.Black)

            TextField(
                value = tripName,
                onValueChange = { tripName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                placeholder = { Text(text = "Enter trip name", color = Color.Gray) },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                )
            )

            Spacer(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .height(1.dp)
                    .background(Color.Black)
            )

            Text(text = "Trip Date", fontSize = 18.sp, color = Color.Black)

            // Clickable text to open the date picker
            Text(
                text = tripDate,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable { showDatePicker = true }, // Open date picker on click
                color = Color.Blue,
                fontSize = 16.sp
            )

            if (showDatePicker) {
                MyDatePickerDialog(
                    onDateSelected = { tripDate = it },
                    onDismiss = { showDatePicker = false }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Round Trip",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.weight(1f))

                Switch(
                    checked = isRoundTrip,
                    onCheckedChange = { isRoundTrip = it },
                    modifier = Modifier.padding(start = 16.dp),
                )
            }
        }
    }
}

@Composable
fun DestinationCompose() {
    Column(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
        Text(text = "Schedule", fontSize = 24.sp)

        Box(
            modifier = Modifier
                .padding(bottom = 20.dp, top = 20.dp)
                .background(color = Color(0xFFEFEFEF), shape = RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Start Time",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "10:00 AM", fontSize = 18.sp,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "End Time",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "11:00 AM", fontSize = 18.sp,
                        color = Color.Black
                    )
                }


            }


        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePickerDialog(
    onDateSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis >= System.currentTimeMillis()
        }
    })

    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(onClick = {
                onDateSelected(selectedDate)
                onDismiss()
            }

            ) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            Button(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancel")
            }
        }
    ) {
        DatePicker(
            state = datePickerState
        )
    }
}

private fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    return formatter.format(Date(millis))
}