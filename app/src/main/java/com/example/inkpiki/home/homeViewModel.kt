package com.example.inkpiki.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.inkpiki.artDetails.Artwork
import com.example.inkpiki.artDetails.ArtworkMocks

class homeViewModel : ViewModel() {
    // Texto actual de la barra de búsqueda
    var query by mutableStateOf("")
        private set
    // Lista base de obras (ahora desde los mocks; en el futuro vendrá de la API)
    private val allArtworks: List<Artwork> = ArtworkMocks.all
    // Obras filtradas en tiempo real según lo que se escriba en la barra
    val filteredArtworks: List<Artwork>
        get() {
            val text = query.trim()
            return if (text.isEmpty()) {
                allArtworks
            } else {
                allArtworks.filter { artwork ->
                    artwork.title.contains(text, ignoreCase = true) ||
                            artwork.authorName.contains(text, ignoreCase = true) ||
                            artwork.category.contains(text, ignoreCase = true)
                }
            }
        }

    fun onQueryChange(newQuery: String) {
        query = newQuery
    }
    fun onSearch() {
        // Aqu irá la llamada a la api cuando se conecte el backend
    }
}