package dev.usrmrz.enotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    background = DarkGray,
    onBackground = Color.White,
    surface = LightBlue,
    onSurface = DarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    onPrimary = Violet,
//    secondary = BabyBlue,
//    onSecondary = Color.White,
//    tertiary = RedPink,
    background = Color(0xFFF3A3F3),
    onBackground = Color(0xFF3F3F3F),
//    surface = Color(0xFF0D47A1),
    onSurface = Color(0xFF1C1B1F),

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun EnotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val noteColorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = noteColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}