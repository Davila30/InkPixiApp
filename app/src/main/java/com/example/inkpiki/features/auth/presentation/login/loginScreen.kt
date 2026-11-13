package com.example.inkpiki.features.auth.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inkpiki.home.HomeScreen
import com.example.inkpiki.ui.theme.InkPikiTheme

@Composable
fun LoginScreen(onNavigateToHome: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla Login: funciona", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToHome) {
            Text(text = "Ir a Home")
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    InkPikiTheme {
        LoginScreen {  }
    }
}