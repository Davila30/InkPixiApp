package com.example.inkpiki.navigation

// Aquí guardo los nombres de las pantallas.
// Uso const val en vez de @Serializable para que sea más fácil.
object Routes {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOME = "home"

    // Detalle de obra: la ruta lleva el id de la obra como parámetro
    const val ARTWORK_ID_ARG = "artworkId"
    const val ARTWORK_DETAIL = "artwork/{$ARTWORK_ID_ARG}"

    // Construye la ruta real: artworkDetail("3") -> "artwork/3"
    fun artworkDetail(artworkId: String) = "artwork/$artworkId"
}