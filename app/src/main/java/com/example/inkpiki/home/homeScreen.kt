package com.example.inkpiki.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember // NUEVO
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inkpiki.artDetails.Artwork // NUEVO
import com.example.inkpiki.artDetails.ArtworkMocks // NUEVO
import com.example.inkpiki.artDetails.priceLabel // NUEVO
import com.example.inkpiki.ui.components.InkPixiBottomNavigation
import com.example.inkpiki.ui.components.InkPixiLogo
import com.example.inkpiki.ui.components.InkPixiSearchBar
import com.example.inkpiki.ui.theme.InkPikiTheme

@Composable
fun HomeScreen(
    // NUEVO: valor por defecto para no tener que pasarlo desde el NavHost
    viewModel: homeViewModel = remember { homeViewModel() },
    onNavigateToHome: () -> Unit = {},
    onNavigateToExplore: () -> Unit = {},
    onNavigateToProfile: () -> Unit,
    onArtworkClick: (String) -> Unit = {} // NUEVO: avisa al NavHost de qué obra se pulsó
) {
    // Texto de la búsqueda. Cuando homeViewModel sea un ViewModel real,
    // este estado se mueve allí y aquí solo se lee.
    var query by rememberSaveable { mutableStateOf("") }

    // NUEVO: obras que coinciden con la búsqueda (por título, autor o categoría).
    // Si no hay texto se muestran todas. Cuando haya API, esto se cambia por la llamada.
    val filteredArtworks = remember(query) {
        val text = query.trim()
        if (text.isEmpty()) {
            ArtworkMocks.all
        } else {
            ArtworkMocks.all.filter { artwork ->
                artwork.title.contains(text, ignoreCase = true) ||
                        artwork.authorName.contains(text, ignoreCase = true) ||
                        artwork.category.contains(text, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = { HomeTopBar() },
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
            ) {
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
        ) {
            HomeHeader()
            // Barra de búsqueda bajo el titular
            InkPixiSearchBar(
                query = query,
                onQueryChange = { query = it },
                onSearch = { /* El filtro ya se aplica al escribir; aquí iría la llamada a la API */ },
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            ActionButtons()
            FeaturedIllustrationsPlaceholder()
            // NUEVO: lista de obras (filtrada por la búsqueda)
            ArtworkResults(
                artworks = filteredArtworks,
                onArtworkClick = onArtworkClick
            )
        }
    }
}
@Composable
fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(horizontal = 24.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        InkPixiLogo()
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
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
        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 16.dp)
    )
}
@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = { },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f).height(48.dp)
        ) {
            Text("Abrir la galería", color = MaterialTheme.colorScheme.onPrimary, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(8.dp))

        }
        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f).height(48.dp)
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
            .height(260.dp)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                .align(Alignment.Center)
        )
        Text("fotos polaroid", color = MaterialTheme.colorScheme.background, fontSize = 14.sp)
    }
}

// NUEVO: sección "Recién llegadas al cuaderno" con las obras.
// Es provisional hasta que esté la cuadrícula real con ArtworkCard,
// que solo tiene que llamar a onArtworkClick(artwork.id) al pulsar una tarjeta.
@Composable
fun ArtworkResults(
    artworks: List<Artwork>,
    onArtworkClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Recién llegadas al cuaderno",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        if (artworks.isEmpty()) {
            // Si la búsqueda no encuentra nada
            Text(
                text = "No hay obras que coincidan con tu búsqueda",
                fontSize = 14.sp,
                color = Color.Gray
            )
        } else {
            artworks.forEach { artwork ->
                Card(
                    onClick = { onArtworkClick(artwork.id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = artwork.title, style = MaterialTheme.typography.titleMedium)
                        Text(
                            text = "By ${artwork.authorName} · ${artwork.priceLabel}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
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
