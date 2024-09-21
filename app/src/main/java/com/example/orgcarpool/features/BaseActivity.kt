package com.example.orgcarpool.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orgcarpool.core.navigation.NavigationRoute
import com.example.orgcarpool.core.theme.OrgCarPoolTheme
import com.example.orgcarpool.features.dashboard.DashboardRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseActivity : ComponentActivity() {

    private var isUserLoggedIn : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrgCarPoolTheme {
                NavigationGraph(
                    startDestination = if(isUserLoggedIn) NavigationRoute.DashboardScreen else NavigationRoute.SplashScreen
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
        startDestination = startDestination,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(500)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(500)
            )
        },
    ){
        composable<NavigationRoute.SplashScreen> {

        }

        composable<NavigationRoute.LoginScreen> {

        }

        composable<NavigationRoute.DashboardScreen> {
            DashboardRoute()
        }
    }
}