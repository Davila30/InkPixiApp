package com.example.inkpiki.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inkpiki.features.auth.presentation.login.LoginScreen
import com.example.inkpiki.home.HomeScreen
import com.example.inkpiki.profile.ProfileScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login
    ) {
        composable<Routes.Login> {
            LoginScreen(
                onNavigateToHome = {
                    navController.navigate(Routes.Home)
                }
            )
        }
        // 2. Home -> Profile
        composable<Routes.Home> {
            HomeScreen(
                viewModel = com.example.inkpiki.home.homeViewModel(),
                onNavigateToProfile = {
                    navController.navigate(Routes.Profile)
                }
            )
        }
        // 3. Profile -> Home
        composable<Routes.Profile> {
            ProfileScreen(
                onNavigateBackToHome = {
                    navController.popBackStack()
                }
            )
        }
    }
}
