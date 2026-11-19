package com.example.inkpiki.features.auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inkpiki.ui.theme.Grey

// A partir de este ancho (y si la pantalla es apaisada) se usan dos columnas
private val TwoColumnMinWidth = 600.dp
// Ancho máximo del formulario para que en tablets no se estire
private val FormMaxWidth = 480.dp

// Contenedor común de Login y Registro (diseño responsivo):
//  - vertical: una columna centrada con scroll
//  - horizontal / pantalla ancha: título a la izquierda y formulario a la derecha
// header = título/logo, form = campos y botones.
@Composable
fun AuthScreenLayout(
    header: @Composable ColumnScope.() -> Unit,
    form: @Composable ColumnScope.() -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Grey)
            .imePadding() // sube el contenido cuando sale el teclado
    ) {
        val twoColumns = maxWidth >= TwoColumnMinWidth && maxWidth > maxHeight
        val scrollState = rememberScrollState()

        if (twoColumns) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Izquierda: título
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = header
                )
                // Derecha: formulario, con scroll si no cabe
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .verticalScroll(scrollState),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.widthIn(max = FormMaxWidth),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = form
                    )
                }
            }
        } else {
            // Una columna: centrada si cabe, con scroll si no
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .widthIn(max = FormMaxWidth)
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    header()
                    Spacer(modifier = Modifier.height(24.dp))
                    form()
                }
            }
        }
    }
}