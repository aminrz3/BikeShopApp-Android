package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.ui.theme.blueGradient1
import amin.rz3.bikeshopping.ui.theme.blueGradient2
import amin.rz3.bikeshopping.ui.theme.cardGradient1
import amin.rz3.bikeshopping.ui.theme.cardGradient2
import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun NavBar(modifier: Modifier = Modifier, navController: NavController){
    val selectedNavBar = remember {
        mutableIntStateOf(0)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
    ){
        NavBarBackground()
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            val navBarItems = listOf(
                R.drawable.bicycle_navbar to "bicycles",
                R.drawable.map_navbar to "map",
                R.drawable.cart_navbar to "cart",
                R.drawable.person_navbar to "profile",
                R.drawable.doc_navbar to "docs"
            )

            navBarItems.forEachIndexed { index, (iconResId, route) ->
                NavBarItem(
                    iconResId = iconResId,
                    isSelected = selectedNavBar.value == index,
                    onClick = {
                        selectedNavBar.value = index
                        navController.navigate(route)
                    }
                )
            }
        }
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun NavBarItem(
    iconResId: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val scale = animateFloatAsState(targetValue = if (isSelected) 1.1f else 1.0f, label = "")
    val padding = animateDpAsState(targetValue = if (isSelected) 0.dp else 25.dp, label = "")

    Box(
        modifier = Modifier
            .size(60.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            )
            .padding(top = padding.value)
            .scale(scale.value),
        contentAlignment = Alignment.Center
    ) {
        if (isSelected) {
            NavBarItemBackground()
        }
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = "",
            alpha = if (isSelected) 1.0f else 0.6f
        )
    }
}


@Composable
fun NavBarBackground(){
    val list =  listOf(cardGradient1, cardGradient2)
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val rect = Rect(Offset.Zero, size)

        val path = Path().apply {
            moveTo(size.width,0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            lineTo(0f, size.height*0.2f)
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
        }

        val paint =  Paint().apply {
            shader = LinearGradientShader(
                rect.topLeft,
                rect.bottomRight,
                list
            )
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

@Composable
fun NavBarItemBackground(){
    val list =  listOf(blueGradient1, blueGradient2)
    val shadowElevationDp = 8.dp

    val density = LocalDensity.current.density
    val shadowElevationPx = shadowElevationDp.value * density
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer(
                shadowElevation = shadowElevationPx,
                shape = RoundedCornerShape(20.dp),
                clip = false
            )
    ) {
        val rect = Rect(Offset.Zero, size)

        val path = Path().apply {
            moveTo(size.width,0f)
            lineTo(size.width, size.height*0.89f)
            lineTo(0f, size.height)
            lineTo(0f, size.height*0.11f)
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
            pathEffect = PathEffect.cornerPathEffect(40f)
        }

        val paint =  Paint().apply {
            shader = LinearGradientShader(
                rect.topLeft,
                rect.bottomRight,
                list
            )
            pathEffect = PathEffect.cornerPathEffect(40f)

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