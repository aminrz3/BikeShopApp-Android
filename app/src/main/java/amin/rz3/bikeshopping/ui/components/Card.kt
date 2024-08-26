package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.ui.theme.BikeShoppingTheme
import amin.rz3.bikeshopping.ui.theme.cardGradient1
import amin.rz3.bikeshopping.ui.theme.cardGradient2
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas

@Composable
fun BikeCard(){
    val gradient =  BikeShoppingTheme.colors.cardGradient
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val rect = Rect(Offset.Zero, size)

        val path = Path().apply {
            moveTo(size.width,0f)
            lineTo(size.width, size.height*0.9f)
            lineTo(0f, size.height)
            lineTo(0f, size.height*0.1f)
            close()

        }

        val borderPaint = Paint().apply {
            shader = LinearGradientShader(
                rect.topLeft,
                rect.bottomRight,
                listOf(
                    Color.White.copy(alpha = 0.2f),
                    Color.Black.copy(alpha = 0.2f)
                )
            )
            style = PaintingStyle.Stroke
            strokeWidth = 6f
            pathEffect = PathEffect.cornerPathEffect(60f)
        }

        val paint =  Paint().apply {
            shader = LinearGradientShader(
                rect.topLeft,
                rect.bottomRight,
                gradient
            )
            pathEffect = PathEffect.cornerPathEffect(60f)

        }
        drawIntoCanvas { canvas ->
            canvas.drawOutline(
                outline = Outline.Generic(path),
                paint = paint
            )

            canvas.drawOutline(
                outline = Outline.Generic(path),
                paint = borderPaint
            )
        }

    }
}