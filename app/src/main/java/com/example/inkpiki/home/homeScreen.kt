package com.example.inkpiki.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inkpiki.ui.components.InkPixiBottomNavigation
import com.example.inkpiki.ui.components.InkPixiLogo
import com.example.inkpiki.ui.theme.InkPikiTheme

@Composable
fun HomeScreen(
    viewModel: homeViewModel,
    onNavigateToHome: () -> Unit = {},
    onNavigateToExplore: () -> Unit = {},
    onNavigateToProfile: () -> Unit
) {
    Scaffold(
        topBar = { HomeTopBar() },
        bottomBar = {
            InkPixiBottomNavigation(
                currentRoute = "home",
                onNavigateHome = onNavigateToHome,
                onNavigateExplore = onNavigateToExplore,
                onNavigateProfile = onNavigateToProfile
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
            ) {
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
        ) {
            HomeHeader()
            ActionButtons()
            FeaturedIllustrationsPlaceholder()
        }
    }
}
@Composable
fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(horizontal = 24.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        InkPixiLogo()
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
        }
    }
}
@Composable
fun HomeHeader() {
    Text(
        text = "Hoy, déjate llevar por una idea.",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp,
        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 16.dp)
    )
}
@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = { },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f).height(48.dp)
        ) {
            Text("Abrir la galería", color = MaterialTheme.colorScheme.onPrimary, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(8.dp))

        }
        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f).height(48.dp)
        ) {
            Text("Crear mi portfolio", color = MaterialTheme.colorScheme.primary, fontSize = 14.sp)
        }
    }
}
@Composable
fun FeaturedIllustrationsPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                .align(Alignment.Center)
        )
        Text("fotos polaroid", color = MaterialTheme.colorScheme.background, fontSize = 14.sp)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    InkPikiTheme {
        HomeScreen(
            viewModel = homeViewModel(),
            onNavigateToProfile = {}
        )
    }
}