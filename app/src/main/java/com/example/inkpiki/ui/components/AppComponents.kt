package com.example.inkpiki.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.size
import com.example.inkpiki.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inkpiki.ui.theme.DarkPurple
import com.example.inkpiki.ui.theme.Darkviolet

@Composable
fun InkPixiLogo(modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = R.drawable.inkpixilogo),
        contentDescription = "logo de InkPixi",
        modifier = modifier.size(80.dp))
}
@Composable
fun InkPixiBottomNavigation(
    currentRoute: String,
    onNavigateHome: () -> Unit,
    onNavigateExplore: () -> Unit,
    onNavigateProfile: () -> Unit
) {
    NavigationBar(
        contentColor = DarkPurple,
        tonalElevation = 8.dp,
        windowInsets = WindowInsets(0.dp) //
    ) {
        val navItemColors = NavigationBarItemDefaults.colors(
            selectedIconColor = DarkPurple,
            selectedTextColor = DarkPurple,
            indicatorColor = Darkviolet,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray
        )

        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = onNavigateHome,
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") },
            colors = navItemColors
        )
        // Pestaña Explorar
        NavigationBarItem(
            selected = currentRoute == "explore",
            onClick = onNavigateExplore,
            icon = { Icon(Icons.Default.Explore, contentDescription = "Explorar") },
            label = { Text("Explorar") },
            colors = navItemColors
        )
        // Pestaña Perfil
        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = onNavigateProfile,
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            colors = navItemColors
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InkPixiBottomNavigationProfilePreview() {
    InkPixiBottomNavigation(
        currentRoute = "profile",
        onNavigateHome = {},
        onNavigateExplore = {},
        onNavigateProfile = {}
    )
}