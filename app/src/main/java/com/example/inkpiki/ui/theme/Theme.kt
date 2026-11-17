package com.example.inkpiki.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Darkviolet,
    secondary = violet,
    tertiary = Pinki,
    background = Color(0xFF121212), //Fondo oscuro genérico
    surface = Color(0xFF1E1E1E), //Superficie oscura
    onPrimary = DarkPurple,
    onSecondary = DarkPurple,
    onBackground = Grey,
    onSurface = Grey
)

private val LightColorScheme = lightColorScheme(
    primary = DarkPurple,
    secondary = Darkviolet,
    tertiary = Pinki,
    background = Grey,
    surface = Color.White, //Para tarjetas (Cards),contenedores y mas...
    primaryContainer = violet, //Para fondos de elementos seleccionados o contenedores primarios
    onPrimary = Color.White, //Texto sobre el color primario (botones)
    onBackground = Color(0xFF1C1B1F), //Texto sobre el fondo
    onSurface = Color(0xFF1C1B1F) //Texto sobre las superficies (Cards)
)

@Composable
fun InkPikiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    //Importante para que se vea en version antigua
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}