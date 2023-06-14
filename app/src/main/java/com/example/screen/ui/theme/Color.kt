package com.example.screen.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

@Immutable
data class DarkModeColors(
    val texts: Color = Color(0xDEFFFFFF),
    val descriptions: Color = Color(0xFF727D8A),
    val focusColors: Color = Color(0xFF1c3952)
) : ThemeColors(
    background = Color(0xFF051016),
    text = texts,
    description = descriptions,
    focusColor = focusColors
)

@Immutable
data class LightModeColors(
    val texts: Color = Color(0xFF092135),
    val descriptions: Color = Color(0xFF999FA1),
    val focusColors: Color = Color(0xFF8AB1D3)
) : ThemeColors(
    background = Color(0xFFF4F4F5),
    text = texts,
    description = descriptions,
    focusColor = focusColors
)

@Immutable
open class ThemeColors(val background: Color, val text: Color, val description: Color, val focusColor: Color)
