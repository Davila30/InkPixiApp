package com.example.inkpiki.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inkpiki.home.HomeTopBar
import com.example.inkpiki.ui.components.ArtworkCard
import com.example.inkpiki.ui.components.InkPixiBottomNavigation
import com.example.inkpiki.ui.theme.Cream
import com.example.inkpiki.ui.theme.InkPikiTheme

private val OpenGreen = Color(0xFF2E7D32) // puntito de "Abierta a nuevos proyectos"
private val TAB_TITLES = listOf("Obras", "Colecciones", "Bocetos y proceso")

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = remember { ProfileViewModel() },
    onNavigateToHome: () -> Unit,
    onNavigateToExplore: () -> Unit = {},
    onArtworkClick: (String) -> Unit = {}
) {
    val profile = viewModel.profile
    val artworks = viewModel.artworks

    Scaffold(
        topBar = { HomeTopBar() },
        bottomBar = {
            InkPixiBottomNavigation(
                currentRoute = "profile",
                onNavigateHome = onNavigateToHome,
                onNavigateExplore = onNavigateToExplore,
                onNavigateProfile = { } // ya estamos en Perfil
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO: subir obra */ },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Subir obra")
            }
        }
    ) { paddingValues ->
        // Cuadrícula adaptable: 2 columnas en móvil vertical, más en horizontal
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 88.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // (provisional) aquí irán la cabecera, las pestañas y la galería
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = "Perfil de ${profile.fullName}",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    InkPikiTheme {
        ProfileScreen(
            viewModel = ProfileViewModel(),
            onNavigateToHome = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 800, heightDp = 400)
@Composable
fun ProfileScreenLandscapePreview() {
    InkPikiTheme {
        ProfileScreen(
            viewModel = ProfileViewModel(),
            onNavigateToHome = {}
        )
    }
}