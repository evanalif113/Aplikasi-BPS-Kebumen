package com.example.bps.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.NavigationBarItemDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bps.R
import com.example.bps.ui.beranda.BerandaScreen
import com.example.bps.ui.statistik.StatistikScreen
import com.example.bps.ui.search.SearchScreen
import com.example.bps.ui.infografik.InfografikScreen
import com.example.bps.theme.*

@OptIn(ExperimentalMaterial3Api::class) // Opt Developer
@Composable
fun MenuScreen() {
    val navController = rememberNavController()
    var showNotif by remember { mutableStateOf(false) }
    var showSettings by remember { mutableStateOf(false) }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                actions = {
                    IconButton(onClick = { showNotif = !showNotif }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_bell_24dp),
                            contentDescription = "Notifications"
                        )
                        DropdownMenu(
                            expanded = showNotif,
                            onDismissRequest = { showNotif = false },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        stringResource(R.string.pengaturan),
                                        color = Gray800,
                                        fontSize = 16.sp
                                    )
                                },
                                onClick = { /* Handle settings click */ }
                            )
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        stringResource(R.string.pengaturan),
                                        color = Gray800,
                                        fontSize = 16.sp
                                    )
                                },
                                onClick = { /* Handle about click */ }
                            )
                        }
                    }
                    IconButton(onClick = { showSettings = !showSettings }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_settings_24dp),
                            contentDescription = "Settings"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Orange500,
                    titleContentColor = Black,
                    actionIconContentColor = Black
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Sky500
            ) {
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
                        onClick = { navController.navigate(title.lowercase()) },
                        colors = NavigationBarItemDefaults.colors( // <-- WARNA IKON DAN TEKS DIUBAH DI SINI
                            selectedIconColor = Black,
                            selectedTextColor = Black,
                            unselectedIconColor = Gray800,
                            unselectedTextColor = Gray800,
                            indicatorColor = Color.Transparent
                        )
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
            composable("statistik") { StatistikScreen() }
            composable("search") { SearchScreen() }
            composable("infografik") { InfografikScreen() }
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen()
}