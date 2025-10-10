package com.example.bps.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bps.theme.Gray200

// Data class untuk menampung informasi berita
data class NewsItem(
    val date: String,
    val title: String
)

// Composable untuk menampilkan satu kartu berita
@Composable
fun NewsCard(newsItem: NewsItem) {
    Card(
        modifier = Modifier.width(150.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            // Placeholder untuk gambar
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Gray200)
            )

            // Konten teks di bawah gambar
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = newsItem.date,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = newsItem.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 18.sp
                )
            }
        }
    }
}

// Composable untuk seluruh bagian "Berita dan Pers"
@Composable
fun NewsSection() {
    // Data dummy untuk ditampilkan
    val newsList = listOf(
        NewsItem("8 Oktober 2025", "RESMI RILIS! Booklet SAKERNAS Agustus 2024 Telah Terbit!"),
        NewsItem("7 Oktober 2025", "Alamat Misterius, Data Sensus Serius"),
        NewsItem("2 Oktober 2025", "Selamat Hari Batik Nasional 2025"),
        NewsItem("2 Oktober 2025", "Pengolahan Peta Wilkerstat")
    )

    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Text(
            text = "Berita dan Pers",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(newsList) { newsItem ->
                NewsCard(newsItem = newsItem)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsSectionPreview() {
    NewsSection()
}