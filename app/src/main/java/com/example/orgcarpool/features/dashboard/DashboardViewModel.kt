package com.example.orgcarpool.features.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orgcarpool.data.remote.ApiService
import com.example.orgcarpool.data.remote.response.TripList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private var _dashboardState = MutableStateFlow(DashboardState())
    val dashboardState = _dashboardState.asStateFlow()

    init {
        getUpComingTrips()
    }

    private fun getUpComingTrips(){
        viewModelScope.launch {
            val response =  apiService.getTrips()
            if(response.isNotEmpty()){
                _dashboardState.update { it.copy(isLoading = false,upComingTrips = response) }
            }
        }
    }
}

data class DashboardState(
    var isLoading: Boolean = true,
    var upComingTrip : TripList.Trip? = null,
    var upComingTrips : List<TripList.Trip> = listOf(),
 )