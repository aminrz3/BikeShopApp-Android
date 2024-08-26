package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.ui.theme.BikeShoppingTheme
import amin.rz3.bikeshopping.ui.theme.Typography
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SquareButton(
    modifier: Modifier = Modifier,
    onClick: ()->Unit,
    isEnable:Boolean=true,
    image:Int?=null,
    text:String?=null,
    size: Dp = 50.dp,
    shadowElevationDp: Dp = 0.dp
){
    val colorBorder = if(isEnable)
        BikeShoppingTheme.colors.blueGradient.map { it.copy(alpha = 0.6f) }
    else
        BikeShoppingTheme.colors.cardGradient.map { it.copy(alpha = 0.2f) }

    val colorBackground = if(isEnable)
        BikeShoppingTheme.colors.blueGradient
    else
        BikeShoppingTheme.colors.cardGradient


    val density = LocalDensity.current.density
    val shadowElevationPx = shadowElevationDp.value * density

    Box(
        modifier = modifier
            .size(size)
            .graphicsLayer(
                shadowElevation = shadowElevationPx,
                shape = RoundedCornerShape(10.dp),
                clip = false
            )
            .background(
                brush = Brush.linearGradient(
                    colors = colorBorder,
                    start = Offset(0f, 0f),
                    end = Offset.Infinite,
                ),
                shape = RoundedCornerShape(10.dp),
            ),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onClick
                )
                .size(size-1.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = colorBackground,
                        start = Offset(0f, 0f),
                        end = Offset.Infinite,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ),
            contentAlignment = Alignment.Center
        ) {
            if(image!=null){
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier.size(size / 2.2f)
                )
            }else if(text!=null){
                Text(
                    text = text,
                    style = Typography.labelMedium,
                    color = Color.White
                )
            }

        }
    }
}