package com.example.inkpiki.artDetails

object ArtworkMocks {

    val all: List<Artwork> = listOf(
        Artwork(
            id = "1",
            title = "Donde duerme la luna",
            description = "Una ilustración digital que explora la tranquilidad de la noche en un valle imaginario. Los tonos fríos contrastan con la cálida luz de las pequeñas casas esparcidas por la montaña. Perfecta para ambientes relajantes.",
            price = 45.0,
            authorName = "Dani Ávila",
            imageUrl = null,
            category = "Ilustración digital"
        ),
        Artwork(
            id = "2",
            title = "La casa de las nueve vidas",
            description = "Un sillón rojo, una gata dormida y una ventana por la que entra la luna. Risografía a dos tintas sobre papel.",
            price = null,
            authorName = "Vera Menta",
            imageUrl = null,
            category = "Risograma"
        ),
        Artwork(
            id = "3",
            title = "Un jardín de bolsillo",
            description = "Nació en un cuaderno pequeño, de esos que caben en el bolsillo del abrigo, durante una tarde de lluvia en la que no se podía salir al parque. " +
                    "Empecé dibujando un invernadero con lápiz y, sin darme cuenta, fui llenándolo de plantas que no existen: helechos con hojas de papel, rosas que se abren al revés y una enredadera que sube hasta el techo de cristal.\n\n" +
                    "El color está hecho con gouache en capas finas, dejando que el trazo de lápiz se vea por debajo. Quería que pareciera un lugar en el que uno pudiera entrar, sentarse y quedarse un rato sin que nadie preguntara nada.\n\n" +
                    "La obra original mide 14 x 9 cm y se entrega enmarcada. Si prefieres una impresión de mayor tamaño, escríbeme y lo hablamos. Todas las piezas se envían o se entregan en mano.",
            price = 60.0,
            authorName = "Inés Sol",
            imageUrl = null,
            category = "Gouache y lápiz"
        ),
        Artwork(
            id = "4",
            title = "Hard GZ",
            description = "Estudio a grafito sobre papel, hecho del natural. Prioricé la textura del pelo y la luz que cae desde un solo lado.",
            price = null,
            authorName = "Ávila",
            imageUrl = null,
            category = "Realismo"
        ),
        Artwork(
            id = "5",
            title = "Hasta donde llega la libertad",
            description = "Pieza conceptual sobre los límites que nos ponemos solos. Técnica mixta sobre papel.",
            price = 120.0,
            authorName = "Ávila",
            imageUrl = null,
            category = "Conceptual"
        ),
        Artwork(
            id = "6",
            title = "Sol y nube",
            description = "Un sol que asoma por detrás de una nube con ojos. Tintas de colores sobre papel.",
            price = null,
            authorName = "Dani Ávila",
            imageUrl = null,
            category = "Escenarios"
        )
    )

    fun findById(id: String): Artwork? = all.firstOrNull { it.id == id }
}