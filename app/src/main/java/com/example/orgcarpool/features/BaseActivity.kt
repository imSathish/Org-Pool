package com.example.orgcarpool.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orgcarpool.core.navigation.NavigationRoute
import com.example.orgcarpool.core.theme.OrgCarPoolTheme

class BaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrgCarPoolTheme {
                NavigationGraph(
                )
            }
        }
    }
}

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationRoute.SplashScreen
    ){
        composable<NavigationRoute.SplashScreen> {  }

        composable<NavigationRoute.LoginScreen> {  }

        composable<NavigationRoute.DashboardScreen> {  }
    }
}