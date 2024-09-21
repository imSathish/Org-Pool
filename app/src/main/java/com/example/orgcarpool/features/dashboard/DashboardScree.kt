package com.example.orgcarpool.features.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DashboardRoute(modifier: Modifier = Modifier) {
    val dashboardViewModel = DashboardViewModel()

    val dashboardUiState by dashboardViewModel.dashboardState.collectAsState()

    DashboardScreen(
        isLoading  = dashboardUiState.isLoading
    )
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen(
        isLoading = true
    )
}

@Composable
fun DashboardScreen(
    isLoading : Boolean,
    modifier: Modifier = Modifier,
) {

}

@Preview
@Composable
private fun CommonLoaderPreview() {
    CommonLoader()
}

@Composable
fun CommonLoader(modifier: Modifier = Modifier) {
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