package amin.rz3.bikeshopping.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val BikeShoppingPallete = BikeShoppingColors(
    uiBackground = bgColor,
    blueGradient = listOf(blueGradient1, blueGradient2),
    cardGradient = listOf(cardGradient1, cardGradient2),
    cardColor1 = cardGradient1,
    cardColor2 = cardGradient2,
    bottomSheetBtn = bottomSheetBtn,
    bottomSheetBtn2 = bottomSheetBtn2,
    bottomSheetText = bottomSheetText,
)

@Composable
fun BikeShoppingTheme(
    content: @Composable () -> Unit
) {
    ProvideBikeShoppingColors(colors = BikeShoppingPallete){
        MaterialTheme(
            colorScheme = debugColors(darkTheme = false),
            typography = Typography,
            content = content,
        )
    }
}

data class BikeShoppingColors(
    val uiBackground: Color,
    val blueGradient: List<Color>,
    val cardGradient: List<Color>,
    val cardColor1: Color,
    val cardColor2: Color,
    val bottomSheetBtn: Color,
    val bottomSheetBtn2: Color,
    val bottomSheetText: Color,
)

object BikeShoppingTheme {
    val colors: BikeShoppingColors
        @Composable
        get() = LocalBikeShoppingColors.current
}

@Composable
fun ProvideBikeShoppingColors(
    colors: BikeShoppingColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalBikeShoppingColors provides colors, content = content)
}

private val LocalBikeShoppingColors = staticCompositionLocalOf<BikeShoppingColors> {
    error("No BikeShoppingColors provided")
}

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = ColorScheme(
    primary = debugColor,
    onPrimary = debugColor,
    primaryContainer = debugColor,
    onPrimaryContainer = debugColor,
    inversePrimary = debugColor,
    secondary = debugColor,
    onSecondary = debugColor,
    secondaryContainer = debugColor,
    onSecondaryContainer = debugColor,
    tertiary = debugColor,
    onTertiary = debugColor,
    tertiaryContainer = debugColor,
    onTertiaryContainer = debugColor,
    background = debugColor,
    onBackground = debugColor,
    surface = debugColor,
    onSurface = debugColor,
    surfaceVariant = debugColor,
    onSurfaceVariant = debugColor,
    surfaceTint = debugColor,
    inverseSurface = debugColor,
    inverseOnSurface = debugColor,
    error = debugColor,
    onError = debugColor,
    errorContainer = debugColor,
    onErrorContainer = debugColor,
    outline = debugColor,
    outlineVariant = debugColor,
    scrim = debugColor,
    surfaceBright = debugColor,
    surfaceDim = debugColor,
    surfaceContainer = debugColor,
    surfaceContainerHigh = debugColor,
    surfaceContainerHighest = debugColor,
    surfaceContainerLow = debugColor,
    surfaceContainerLowest = debugColor,
)