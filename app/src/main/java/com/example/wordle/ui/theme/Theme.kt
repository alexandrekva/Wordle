package com.example.wordle.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = MayaBlue,
    primaryVariant = YaleBlue,
    secondary = LightGreen,
    secondaryVariant = ShinyShamrock,
    background = BlackOlive,
    onBackground = Cultured,
    error = FireOpel,
    onError = EerieBlack,
    surface = BlackOlive,
    onSurface = Cultured,
    onPrimary = Cultured,
    onSecondary = BlackOlive
)

private val LightColorPalette = lightColors(
    primary = MayaBlue,
    primaryVariant = YaleBlue,
    secondary = LightGreen,
    secondaryVariant = ShinyShamrock,
    background = Cultured,
    onBackground = EerieBlack,
    error = FireOpel,
    onError = Cultured,
    surface = EerieBlack,
    onSurface = EerieBlack,
    onPrimary = Cultured,
    onSecondary = EerieBlack
)

@Composable
fun WordleTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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