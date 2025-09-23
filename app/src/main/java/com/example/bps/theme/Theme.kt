package com.example.bps.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Skema warna untuk Tema Gelap (Dark Theme)
private val DarkColorScheme = darkColorScheme(
    primary = Indigo200, // Warna dari themes.xml (night)
    secondary = Teal200,  // Warna dari themes.xml (night)
    onPrimary = Black,
    onSecondary = Black
    // Anda bisa menyesuaikan warna lain sesuai kebutuhan
)

// Skema warna untuk Tema Terang (Light Theme)
private val LightColorScheme = lightColorScheme(
    primary = Orange500,
    primaryContainer = Orange700,
    secondary = Emerald200,
    secondaryContainer = Emerald700,
    onPrimary = White,
    onSecondary = Black
)

@Composable
fun MeteoSenseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}