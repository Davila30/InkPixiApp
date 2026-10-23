package com.example.inkpiki.navigation

import kotlinx.serialization.Serializable

sealed interface Routes{
    @Serializable
    data object Register : Routes
    @Serializable
    object Register: Routes("Register")
    @Serializable
    object Login: Routes("Login")
    @Serializable
    object Home: Routes("Home")
    @Serializable
    object Profile: Routes("Home")
}