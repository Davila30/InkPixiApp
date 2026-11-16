package com.example.inkpiki.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

        // Home con texto prueba
        composable(Routes.HOME) {
            Text("Home (pendiente)")
        }
    }
}

