package com.shobu95.crebitscompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = darkColors(
    primary = ThemeWhite,
    primaryVariant = ThemeWhite,
    secondary = ThemeBlack,
    surface = ThemeBackgroundLight,
    onSurface = ThemeBlack
)

private val DarkColorPalette = lightColors(
    primary = ThemeBlack,
    primaryVariant = ThemeBlack,
    secondary = ThemeWhite,
    surface = ThemeBackgroundDark,
    onSurface = ThemeWhite

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
fun CrebitsComposeTheme(
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