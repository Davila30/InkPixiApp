package com.example.inkpiki.navigation

import kotlinx.serialization.Serializable

// Aquí guardo los nombres de las pantallas.
// Uso const val en vez de @Serializable para que sea más fácil.
object Routes {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOME = "home"
}