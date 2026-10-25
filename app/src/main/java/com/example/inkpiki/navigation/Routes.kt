package com.example.inkpiki.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {
    @Serializable
    object Register: Routes("registerScreen")
    @Serializable
    object Login: Routes("loginScreen")
    @Serializable
    object Home: Routes("homeScreen")
    @Serializable
    object Profile: Routes("profileScreen")
}