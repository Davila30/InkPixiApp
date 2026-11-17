package com.example.inkpiki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.inkpiki.home.HomeScreenPreview
import com.example.inkpiki.navigation.AppNavHost
import com.example.inkpiki.ui.theme.InkPikiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InkPikiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Aquí cargamos la navegación, que empieza en el login
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavHost()
                        HomeScreenPreview()
                    }
                }
            }
        }
    }
}