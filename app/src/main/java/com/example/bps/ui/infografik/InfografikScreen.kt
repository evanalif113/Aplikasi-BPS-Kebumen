package com.example.bps.ui.infografik

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bps.ui.beranda.CardCarousel
import com.example.bps.components.SearchBar

@Composable
fun InfografikScreen() {
    // Column sekarang bisa di-scroll untuk mengakomodasi lebih banyak konten
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Infografik",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        CardCarousel()
        Spacer(modifier = Modifier.height(24.dp))
        // Menambahkan SearchBar di sini
        SearchBar()
    }
}