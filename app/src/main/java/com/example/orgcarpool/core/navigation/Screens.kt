package com.example.orgcarpool.core.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class NavigationRoute{

    //LoginModule
    @Serializable
    data object RootModule : NavigationRoute()

    //Splash
    data object SplashScreen : NavigationRoute()

    //LoginModule
    @Serializable
    data object LoginScreen : NavigationRoute()

    //LoginModule
    @Serializable
    data object DashboardScreen : NavigationRoute()
}