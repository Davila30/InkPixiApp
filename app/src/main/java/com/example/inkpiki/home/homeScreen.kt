package com.example.inkpiki.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inkpiki.R
import com.example.inkpiki.ui.components.ArtworkCard
import com.example.inkpiki.ui.components.InkPixiBottomNavigation
import com.example.inkpiki.ui.components.InkPixiLogo
import com.example.inkpiki.ui.components.InkPixiSearchBar
import com.example.inkpiki.ui.theme.InkPikiTheme

@Composable
fun HomeScreen(
    viewModel: homeViewModel = remember { homeViewModel() },
    onNavigateToHome: () -> Unit = {},
    onNavigateToExplore: () -> Unit = {},
    onNavigateToProfile: () -> Unit,
    onArtworkClick: (String) -> Unit = {}
) {
    val artworks = viewModel.filteredArtworks

    Scaffold(
        topBar = { HomeTopBar(onProfileClick = onNavigateToProfile) },
        bottomBar = {
            InkPixiBottomNavigation(
                currentRoute = "home",
                onNavigateHome = onNavigateToHome,
                onNavigateExplore = onNavigateToExplore,
                onNavigateProfile = onNavigateToProfile
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
            }
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(start = 24.dp, end = 24.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Cabecera y buscador ocupando las 2 columnas
            item(span = { GridItemSpan(maxLineSpan) }) {
                Column {
                    HomeHeader()
                    InkPixiSearchBar(
                        query = viewModel.query,
                        onQueryChange = { viewModel.onQueryChange(it) },
                        onSearch = { viewModel.onSearch() }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ActionButtons()
                    FeaturedIllustrationsPlaceholder()
                    Text(
                        text = "Recién llegadas al cuaderno",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
            }

            if (artworks.isEmpty()) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Text(
                        text = "No hay obras que coincidan con tu búsqueda",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
            } else {
                items(artworks, key = { it.id }) { artwork ->
                    ArtworkCard(
                        artwork = artwork,
                        onClick = { onArtworkClick(artwork.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun HomeTopBar(onProfileClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(horizontal = 24.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        InkPixiLogo()
        IconButton(
            onClick = onProfileClick,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        ) {
        }
    }
}

@Composable
fun HomeHeader() {
    Text(
        text = "Hoy, déjate llevar por una idea.",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
    )
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = { },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
        ) {
            Text("Abrir la galería", color = MaterialTheme.colorScheme.onPrimary, fontSize = 14.sp)
        }
        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
        ) {
            Text("Crear mi portfolio", color = MaterialTheme.colorScheme.primary, fontSize = 14.sp)
        }
    }
}

@Composable
fun FeaturedIllustrationsPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(vertical = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fotoinicio),
            contentDescription = "Fotode inicio",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    InkPikiTheme {
        HomeScreen(
            viewModel = homeViewModel(),
            onNavigateToProfile = {}
        )
    }
}