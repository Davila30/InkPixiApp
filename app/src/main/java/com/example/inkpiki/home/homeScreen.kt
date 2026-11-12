package com.example.inkpiki.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import com.example.inkpiki.ui.theme.Purple40
import com.example.inkpiki.ui.theme.Grey

@Composable
fun HomeScreen(
    viewModel: homeViewModel,
    onNavigateToProfile: () -> Unit) {
    Scaffold(
        topBar = { HomeTopBar() },
        //bottomBar = { HomeBottomNavigation(onNavigateToProfile) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
            ) {
            }
        },
        containerColor = Color.Grey
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            HomeHeader()
        }
    }
}
@Composable
fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.background(LightPurpleBg)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "InkPixi",
            color = Purple40,
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
        }
    }
}
@Composable
fun HomeHeader() {
    Text(
        text = "Hoy, déjate llevar por una idea.",
        //color = TextDark,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp,
        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 16.dp)
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        viewModel = homeViewModel(),
        onNavigateToProfile = {}
    )
}