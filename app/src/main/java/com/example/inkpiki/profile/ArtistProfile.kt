package com.example.inkpiki.profile

// Datos del artista que se muestran en la cabecera del perfil.
// Mezcla campos de User (nombre, username, ubicación, avatar) y de Portfolio (bio),
// igual que haremos cuando venga de la API.
data class ArtistProfile(
    val fullName: String,
    val username: String,
    val location: String,
    val bio: String,
    val avatarUrl: String?,
    val tags: List<String>,
    val isOpenToWork: Boolean,
    val languages: List<String>,
    // Nombre con el que aparecen sus obras en ArtworkMocks (así sabemos cuáles son suyas)
    val authorName: String
)

// Datos de prueba hasta que haya API (los textos salen del Figma)
object ArtistProfileMocks {
    val daniAvila = ArtistProfile(
        fullName = "Dani ávila",
        username = "avila.illo",
        location = "Málaga, España",
        bio = "Me gusta dibujar y me gustan los furros más de lo que debería y más de lo que me gustaría admitir",
        avatarUrl = null,
        tags = listOf("Fantasía acogedora", "Oscuro y lápiz", "Concept art"),
        isOpenToWork = true,
        languages = listOf("Español", "Inglés"),
        authorName = "Ávila"
    )
}