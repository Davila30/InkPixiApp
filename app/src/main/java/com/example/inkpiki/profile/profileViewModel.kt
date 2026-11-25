package com.example.inkpiki.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.inkpiki.artDetails.Artwork
import com.example.inkpiki.artDetails.ArtworkMocks

class ProfileViewModel : ViewModel() {
    // Artista que se está viendo (mock; en el futuro vendrá de la API según el username)
    val profile: ArtistProfile = ArtistProfileMocks.daniAvila

    // Obras publicadas por ese artista (mock)
    val artworks: List<Artwork> = ArtworkMocks.all.filter { it.authorName == profile.authorName }

    // Pestaña seleccionada: 0 = Obras, 1 = Colecciones, 2 = Bocetos y proceso
    var selectedTab by mutableIntStateOf(0)
        private set

    fun onTabSelected(index: Int) {
        selectedTab = index
    }
}