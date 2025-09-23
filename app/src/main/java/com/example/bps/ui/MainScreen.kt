package com.example.meteosense.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bps.R
import com.example.bps.ui.beranda.BerandaScreen
import com.example.bps.theme.*

@OptIn(ExperimentalMaterial3Api::class) // Opt Developer
@Composable
fun MenuScreen() {
    val navController = rememberNavController()
    var showMenu by remember { mutableStateOf(false) }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Aksi untuk membuka drawer */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "Navigation Menu"
                        )
                    }
                },
                title = {
                    Text(text = stringResource(id = R.string.app_name))

                },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(Icons.Default.Notifications,
                            contentDescription = "Settings")
                    }
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(painterResource(id = R.drawable.ic_settings_24dp),
                            contentDescription = "Settings")
                    }
                },
                // --- PERUBAHAN DI SINI ---
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Gray200, // Mengatur warna background
                    titleContentColor = White,       // Mengatur warna teks judul
                    actionIconContentColor = White   // Mengatur warna ikon
                )
                // -------------------------
            )
        },
        bottomBar = {
            BottomAppBar {
                val icons = listOf(
                    "Beranda" to R.drawable.ic_house_24dp,
                    "Statistik" to R.drawable.ic_grafik_24dp,
                    "Search" to R.drawable.ic_search_24dp,
                    "Infografik" to R.drawable.ic_open_book_24dp,
                    "Lainnya" to R.drawable.ic_menu_24dp

                )
                icons.forEach { (title, iconRes) ->
                    NavigationBarItem(
                        icon = { Icon(painterResource(id = iconRes), contentDescription = title) },
                        label = { Text(title) },
                        selected = navController.currentDestination?.route == title.lowercase(),
                        onClick = { navController.navigate(title.lowercase()) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "beranda",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("beranda") { BerandaScreen() }
            // Tambahkan tujuan navigasi lainnya di sini
        }
    }
}