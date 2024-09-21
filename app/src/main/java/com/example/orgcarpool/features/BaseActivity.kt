package com.example.orgcarpool.features

import LoginScreen
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseActivity : ComponentActivity() {

    private var isUserLoggedIn : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrgCarPoolTheme {
                NavigationGraph(
//                    startDestination = if(isUserLoggedIn) NavigationRoute.DashboardScreen else NavigationRoute.SplashScreen
                    startDestination = NavigationRoute.LoginScreen
                )
            }
        }
    }

}

@Composable
fun NavigationGraph(
    startDestination : NavigationRoute,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable<NavigationRoute.SplashScreen> {
            LoginScreen(navController = navController)
        }

        composable<NavigationRoute.LoginScreen> {
            LoginScreen(navController = navController)
        }

        composable<NavigationRoute.DashboardScreen> {

        }
    }
}