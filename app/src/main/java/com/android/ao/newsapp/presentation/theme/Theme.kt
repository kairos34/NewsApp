package com.android.ao.newsapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    secondary = secondaryColor,
    primaryVariant = primaryDarkColor,
    secondaryVariant = secondaryDarkColor,
    surface = secondaryLightColor,
    onPrimary = primaryTextColor,
    onSecondary = primaryTextColor,
    onSurface = primaryLightColor
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    secondary = secondaryColor,
    primaryVariant = primaryDarkColor,
    secondaryVariant = secondaryDarkColor,
    surface = secondaryLightColor,
    onPrimary = primaryTextColor,
    onSecondary = primaryTextColor,
    onSurface = primaryLightColor
)

@Composable
fun NewsAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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