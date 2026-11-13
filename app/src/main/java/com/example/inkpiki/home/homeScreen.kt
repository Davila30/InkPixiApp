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
import com.example.inkpiki.ui.theme.DarkPurple
import com.example.inkpiki.ui.theme.Darkviolet
import com.example.inkpiki.ui.theme.Pinki
import com.example.inkpiki.ui.theme.Grey
import com.example.inkpiki.ui.theme.violet

@Composable
fun HomeScreen(
    viewModel: homeViewModel,
    onNavigateToProfile: () -> Unit) {
    Scaffold(
        topBar = { HomeTopBar() },
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
                .background(Grey)
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
            .background(Darkviolet)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "InkPixi",
            color = DarkPurple,
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(DarkPurple),
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
            colors = ButtonDefaults.buttonColors(containerColor = DarkPurple),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f).height(48.dp)
        ) {
            Text("Abrir la galería", color = Color.White, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(8.dp))

        }

        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Darkviolet),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.weight(1f).height(48.dp)
        ) {
            Text("Crear mi portfolio", color = DarkPurple, fontSize = 14.sp)
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
                .background(DarkPurple.copy(alpha = 0.5f))
                .align(Alignment.Center)
        )
        Text("fotos polaroid", color = Grey, fontSize = 14.sp)
    }
}



@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        viewModel = homeViewModel(),
        onNavigateToProfile = {}
    )
}