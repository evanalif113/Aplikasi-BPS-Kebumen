package com.example.bps.ui.statistik

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bps.R
import com.example.bps.theme.*

@Composable
fun StatistikScreen() {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Text(
            text = "Statistik",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        CardCarousel()
    }
}

/**
 * Composable yang menampilkan daftar kartu secara horizontal (Carousel).
 */
@Composable
fun CardCarousel() {
    // LazyRow digunakan untuk efisiensi, hanya merender item yang terlihat di layar.
    LazyRow(
        // Memberi padding di sisi kiri dan kanan daftar
        contentPadding = PaddingValues(horizontal = 16.dp),
        // Mengatur jarak antar setiap kartu
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Menampilkan 5 kartu sebagai contoh
        items(5) {
            CarouselItem()
        }
    }
}

/**
 * Composable untuk satu item kartu di dalam carousel.
 */
@Composable
fun CarouselItem() {
    Card(
        modifier = Modifier.size(100.dp), // Ukuran kartu
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Gray200)
    ) {
        // Box digunakan untuk menempatkan ikon di tengah kartu
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Ikon placeholder
            Icon(
                painter = painterResource(id = R.drawable.ic_bell_24dp),
                contentDescription = "Placeholder Icon",
                modifier = Modifier.size(48.dp),
                tint = Gray200
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatistikScreenPreview() {
    StatistikScreen()
}