package com.example.inkpiki.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.inkpiki.artDetails.ArtworkCatalogPlaceholder
import com.example.inkpiki.artDetails.ArtworkDetailScreen
import com.example.inkpiki.features.auth.presentation.login.LoginScreen
import com.example.inkpiki.features.auth.presentation.register.RegisterScreen

@Composable
fun AppNavHost() {
    // El navController pa mover de pantalla a pantalla
    val navController = rememberNavController()

    // startDestination = la primera pantalla que se ve (el login)
    NavHost(navController = navController, startDestination = Routes.LOGIN) {

        // Pantalla de login
        composable(Routes.LOGIN) {
            LoginScreen(
                // Si el login es correcto vamos a Home y borramos el login del historial
                onLoginSuccess = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                },
                // Si pulsa "Regístrate" vamos al registro
                onGoToRegister = { navController.navigate(Routes.REGISTER) }
            )
        }

        // Pantalla de registro
        composable(Routes.REGISTER) {
            RegisterScreen(
                // Al crear la cuenta volvemos al login
                onRegisterSuccess = { navController.popBackStack() },
                // Botón de volver
                onBackToLogin = { navController.popBackStack() }
            )
        }

        // Home: catálogo provisional hasta que esté la cuadrícula con ArtworkCard
        composable(Routes.HOME) {
            ArtworkCatalogPlaceholder(
                // Al pulsar una obra vamos a su detalle pasando el id
                onArtworkClick = { artworkId ->
                    navController.navigate(Routes.artworkDetail(artworkId))
                }
            )
        }

        // Detalle de obra: la ruta lleva el id como parámetro
        composable(
            route = Routes.ARTWORK_DETAIL,
            arguments = listOf(
                navArgument(Routes.ARTWORK_ID_ARG) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val artworkId = backStackEntry.arguments?.getString(Routes.ARTWORK_ID_ARG).orEmpty()
            ArtworkDetailScreen(
                artworkId = artworkId,
                // Botón de arriba y gesto atrás: vuelve al catálogo sin recargar
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}