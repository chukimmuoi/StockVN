package com.chukimmuoi.stockvn.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple300, // Choose
    primaryVariant = Purple700,
    onPrimary = Color.Black,
    secondary = Purple300,
    onSecondary = Color.Black,
    error = Purple200,
    onBackground = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Purple700, // Choose
    primaryVariant = Purple900,
    onPrimary = Color.White,
    secondary = Purple700,
    secondaryVariant = Purple900,
    onSecondary = Color.White,
    error = Purple800,
    onBackground = Color.Black,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun StockVNTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}