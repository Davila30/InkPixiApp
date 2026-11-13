package com.example.inkpiki.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object Register : Routes
    @Serializable
    data object Login : Routes
    @Serializable
    data object Home : Routes
    @Serializable
    data object Profile : Routes
}
