package com.example.inkpiki.artDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inkpiki.ui.theme.DarkPurple
import com.example.inkpiki.ui.theme.Darkviolet
import com.example.inkpiki.ui.theme.Grey


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtworkDetailScreen(
    onNavigateBack: () -> Unit // Ejecuta el popBackStack()
) {
    val artwork = ArtworkMocks.all.first() // Datos mock hasta que haya API
    var showDeleteDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle de obra", fontSize = 18.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = DarkPurple,
                    navigationIconContentColor = Darkviolet
                )
            )
        },
        containerColor = Color.White
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())//Scroll vertical
        ) {
            //Imagen destacada (Cabecera)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.LightGray), // Placeholder de la imagen
                contentAlignment = Alignment.Center
            ) {

            }
            //Bloque de info de la obra
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                /*Text(
                    text = artwork.category.uppercase(),
                    color = Grey,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )*/
                Spacer(modifier = Modifier.height(4.dp))
                // Título
                Text(
                    text = artwork.title,
                    color = Color.DarkGray,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Autor
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "By ${artwork.authorName}",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = artwork.priceLabel,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                //Descripocon
                Text(
                    text = "Descripción",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = artwork.description,
                    color = Color.Black,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Justify
                )
                //Botonees
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = { /* Acción de editar si eeres el autor */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Darkviolet),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text("Editar Publicación", fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedButton(
                    onClick = { showDeleteDialog = true }, // Abre el modal
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFD32F2F)), // Rojo error
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {

                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Eliminar Obra", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
    //Dialogo modal de confirmación
    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = {
                Text(text = "Eliminar publicación", fontWeight = FontWeight.Bold)
            },
            text = {
                Text(text = "¿Estás seguro de que deseas eliminar '${artwork.title}'? Esta acción es irreversible y la obra desaparecerá de la galería.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDeleteDialog = false
                        onNavigateBack() //se supone regresa al catálogo tras eliminar
                        //TODO: Eliminar la publicación
                    }
                ) {
                    Text("Eliminar", color = Color(0xFFD32F2F), fontWeight = FontWeight.Bold) // Texto en rojo
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDeleteDialog = false }
                ) {
                    Text("Cancelar", color = Color.Black, fontWeight = FontWeight.Bold)
                }
            },
            containerColor = Color.White
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtworkDetailScreenPreview() {
    ArtworkDetailScreen(
        onNavigateBack = { /* Simula el popBackStack */ }
    )
}