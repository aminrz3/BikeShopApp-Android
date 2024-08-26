package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.ui.theme.BikeShoppingTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun BikeBackground(
    modifier:Modifier = Modifier,
    colorGradient:List<Color> = BikeShoppingTheme.colors.blueGradient,
    content: @Composable () -> Unit
){
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    val density = LocalDensity.current
    val rotationAngle = 30f
    val translationY = with(density) { (screenHeight / 6).toPx() }
    val translationX = with(density) { (screenWidth / 3).toPx() }
    Box(
        modifier = modifier
            .padding(top = screenHeight / 10)
            .graphicsLayer(
                rotationZ = rotationAngle,
                translationY = translationY,
                translationX = translationX
            )

            .drawWithCache {
                val gradient = Brush.linearGradient(
                    colors = colorGradient,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, size.height)
                )
                onDrawBehind {
                    drawRect(brush = gradient)
                }
            }
            .fillMaxSize()
    )

    content()

}