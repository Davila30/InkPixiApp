package com.example.inkpiki.features.auth.presentation.login

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
fun LoginScreen(
    onLoginSuccess: () -> Unit,   // qué hacer si el login va bien
    onGoToRegister: () -> Unit,   // qué hacer si pulsa "Regístrate"
    viewModel: LoginViewModel = remember { LoginViewModel() }
) {
    // AuthScreenLayout se encarga de adaptar la pantalla (vertical, horizontal, tablet)
    AuthScreenLayout(
        header = {
            // Nombre de la app
            Text(
                text = "InkPixi",
                color = DarkPurple,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Título como en Figma
            Text(
                text = "¡Hola de nuevo!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        },
        form = {
            // Campo del correo
            OutlinedTextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                label = { Text("Correo electrónico") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Campo de la contraseña (PasswordVisualTransformation pone los puntitos)
            OutlinedTextField(
                value = viewModel.password,
                onValueChange = { viewModel.password = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            // Si hay error, lo mostramos en rojo
            if (viewModel.errorMessage.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = viewModel.errorMessage, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de iniciar sesión
            Button(
                onClick = {
                    // Si los datos son correctos, avisamos para ir a Home
                    if (viewModel.onLoginClick()) {
                        onLoginSuccess()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = DarkPurple),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Iniciar sesión")
            }

            // Texto para ir al registro
            TextButton(onClick = onGoToRegister) {
                Text("¿No tienes cuenta? Regístrate", color = DarkPurple)
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
fun LoginScreenPreview() {
    InkPikiTheme {
        LoginScreen(onLoginSuccess = {}, onGoToRegister = {})
    }
}