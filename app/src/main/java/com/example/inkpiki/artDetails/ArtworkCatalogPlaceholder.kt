package com.example.inkpiki.artDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// PROVISIONAL: lista simple para poder probar la navegación al detalle.
// Se borra cuando esté la cuadrícula real (LazyVerticalGrid + ArtworkCard),
// que solo tiene que llamar a onArtworkClick(artwork.id) al pulsar una tarjeta.
@Composable
fun ArtworkCatalogPlaceholder(
    onArtworkClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(ArtworkMocks.all, key = { it.id }) { artwork ->
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
}