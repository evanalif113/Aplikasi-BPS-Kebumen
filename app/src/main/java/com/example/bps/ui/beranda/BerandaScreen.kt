package com.example.bps.ui.beranda

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bps.R
import com.example.bps.components.SearchBar
import com.example.bps.theme.*

@Composable
fun BerandaScreen() {
    // Column sekarang bisa di-scroll untuk mengakomodasi lebih banyak konten
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Beranda",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        CardCarousel()
        Spacer(modifier = Modifier.height(24.dp))
        // Menambahkan SearchBar di sini
        SearchBar()
        Spacer(modifier = Modifier.height(24.dp))
        CardCarousel()
    }
}

/**
 * Composable yang menampilkan daftar kartu secara horizontal (Carousel).
 */
@Composable
fun CardCarousel() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
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
        modifier = Modifier.size(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Gray200)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_open_book_24dp),
                contentDescription = "Placeholder Icon",
                modifier = Modifier.size(48.dp),
                tint = Green600
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BerandaScreenPreview() {
    BerandaScreen()
}