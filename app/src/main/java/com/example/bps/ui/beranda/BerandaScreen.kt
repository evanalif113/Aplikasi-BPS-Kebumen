package com.example.bps.ui.beranda

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bps.R
import com.example.bps.components.SearchBar
import com.example.bps.components.CardCarousel
import com.example.bps.theme.*

// 1. Tampilan utama BerandaScreen
@Composable
fun BerandaScreen() {
    // Column ini sudah benar untuk membuat seluruh layar bisa di-scroll
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        // Carousel Section menggunakan CardCarousel
        CardCarousel()
        Spacer(modifier = Modifier.height(24.dp))

        // SearchBar di bagian atas
        SearchBar()
        Spacer(modifier = Modifier.height(24.dp))

        // Bagian Menu Utama (Infografi, Statistik, Lainnya)
        MainMenuSection()
        Spacer(modifier = Modifier.height(24.dp))

        // Bagian Info Sensus
        InfoSensusSection()
    }
}

// 3. Composable untuk bagian Menu Utama
@Composable
fun MainMenuSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E88E5)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MainMenuItem(iconRes = R.drawable.ic_open_book_24dp, title = "Infografis", color = Orange500)
            MainMenuItem(iconRes = R.drawable.ic_grafik_24dp, title = "Statistik", color = Green500)
            MainMenuItem(iconRes = R.drawable.ic_search_24dp, title = "Search", color = Blue500)
            MainMenuItem(iconRes = R.drawable.ic_menu_24dp, title = "Lainnya", color = Gray500)
        }
    }
}

// 4. Composable untuk setiap item di dalam Menu Utama
@Composable
fun MainMenuItem(iconRes: Int, title: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .size(72.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = title,
                    tint = color,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            lineHeight = 14.sp
        )
    }
}

// 5. Composable untuk bagian Info Sensus
@Composable
fun InfoSensusSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Info Sensus",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        // Banner Sensus dengan gambar yang sesuai
        SensusBanner(
            imageRes = R.drawable.ic_open_book_24dp,
            contentDescription = "Sensus Penduduk 2020",
            backgroundColor = Sky500
        )
        Spacer(modifier = Modifier.height(16.dp))
        SensusBanner(
            imageRes = R.drawable.ic_open_book_24dp,
            contentDescription = "Sensus Pertanian 2023",
            backgroundColor = Green500
        )
        Spacer(modifier = Modifier.height(16.dp))
        SensusBanner(
            imageRes = R.drawable.ic_open_book_24dp,
            contentDescription = "Sensus Ekonomi 2026",
            backgroundColor = Orange500
        )
    }
}

// 6. Composable untuk setiap banner Sensus
@Composable
fun SensusBanner(imageRes: Int, contentDescription: String, backgroundColor: Color = Color.White) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icon/Logo sensus
                Icon(
                    painter = painterResource(id = imageRes),
                    contentDescription = contentDescription,
                    tint = if (backgroundColor == Color(0xFF2196F3)) Color.White else Color(0xFF2196F3),
                    modifier = Modifier.padding(end = 16.dp)
                )
                
                // Text content
                Text(
                    text = contentDescription,
                    color = if (backgroundColor == Color(0xFF2196F3)) Color.White else Color.Black,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BerandaScreenPreview() {
    BerandaScreen()
}