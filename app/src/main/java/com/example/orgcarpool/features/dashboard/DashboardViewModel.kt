package com.example.orgcarpool.features.dashboard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel:ViewModel() {

    private var _dashboardState = MutableStateFlow(DashboardState())
    val dashboardState = _dashboardState.asStateFlow()
}

data class DashboardState(
    var isLoading : Boolean = false,

)