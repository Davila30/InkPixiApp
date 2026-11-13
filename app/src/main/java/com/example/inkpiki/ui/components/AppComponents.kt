package com.example.inkpiki.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inkpiki.ui.theme.DarkPurple

@Composable
fun InkPixisLogo(modifier: Modifier = Modifier) {
    Text(
        text = "InkPixis",
        color = DarkPurple,
        fontSize = 36.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = modifier.padding(vertical = 32.dp)
    )
}
