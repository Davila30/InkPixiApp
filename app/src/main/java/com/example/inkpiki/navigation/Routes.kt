package com.example.inkpiki.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {
    @Serializable
    object Register: Routes("Register")
    @Serializable
    object Login: Routes("Login")
    @Serializable
    object Home: Routes("Home")
    @Serializable
    object Profile: Routes("Home")
}