package com.example.inkpiki.features.auth.presentation.register

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inkpiki.features.auth.presentation.components.AuthScreenLayout
import com.example.inkpiki.ui.theme.DarkPurple
import com.example.inkpiki.ui.theme.InkPikiTheme

@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,  // qué hacer cuando se crea la cuenta
    onBackToLogin: () -> Unit,      // qué hacer al pulsar "Inicia sesión"
    viewModel: RegisterViewModel = remember { RegisterViewModel() }
) {
    // AuthScreenLayout se encarga de adaptar la pantalla (vertical, horizontal, tablet)
    AuthScreenLayout(
        header = {
            // Título como en Figma
            Text(
                text = "Regístrate para empezar",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = DarkPurple,
                textAlign = TextAlign.Center
            )
        },
        form = {
            // Campo del nombre de usuario
            OutlinedTextField(
                value = viewModel.username,
                onValueChange = { viewModel.username = it },
                label = { Text("Usuario") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Campo del correo
            OutlinedTextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                label = { Text("Correo electrónico") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Campo de la contraseña (con puntitos)
            OutlinedTextField(
                value = viewModel.password,
                onValueChange = { viewModel.password = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Casilla de aceptar términos (el texto puede saltar de línea en pantallas estrechas)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = viewModel.acceptTerms,
                    onCheckedChange = { viewModel.acceptTerms = it }
                )
                Text(
                    text = "Acepto los términos y condiciones",
                    modifier = Modifier.weight(1f)
                )
            }

            // Mensaje de error en rojo si hay alguno
            if (viewModel.errorMessage.isNotEmpty()) {
                Text(text = viewModel.errorMessage, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de crear cuenta
            Button(
                onClick = {
                    // Si los datos son correctos, avisamos para volver al login
                    if (viewModel.onRegisterClick()) {
                        onRegisterSuccess()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = DarkPurple),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Crear cuenta")
            }

            // Texto para volver al login
            TextButton(onClick = onBackToLogin) {
                Text("¿Ya tienes cuenta? Inicia sesión", color = DarkPurple)
            }
        }
    )
}

@Preview(name = "Móvil vertical", widthDp = 360, heightDp = 780)
@Preview(name = "Móvil pequeño", widthDp = 320, heightDp = 480)
@Preview(name = "Móvil horizontal", widthDp = 780, heightDp = 360)
@Preview(name = "Tablet vertical", widthDp = 800, heightDp = 1280)
@Preview(name = "Tablet horizontal", widthDp = 1280, heightDp = 800)
@Composable
fun RegisterScreenPreview() {
    InkPikiTheme {
        RegisterScreen(onRegisterSuccess = {}, onBackToLogin = {})
    }
}