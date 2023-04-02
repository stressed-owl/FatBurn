package com.cute_white_bear.fitnessapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = md_theme_dark_background,
    primary = md_theme_dark_primary,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary,
)

private val LightColorPalette = lightColors(
    background = md_theme_light_background,
    primary = md_theme_light_primary,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    onPrimary = md_theme_light_onPrimary,
    secondary = md_theme_light_secondary,
)

@Composable
fun FitnessAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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