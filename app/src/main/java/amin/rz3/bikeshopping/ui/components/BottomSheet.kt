package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.ui.commons.Helper
import amin.rz3.bikeshopping.ui.theme.BikeShoppingTheme
import amin.rz3.bikeshopping.ui.theme.Typography
import android.graphics.BlurMaskFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.EventLogTags.Description
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BikeBottomSheet(modifier: Modifier = Modifier, itemDetail:ItemDetail,onSheetStateChange: (SheetValue) -> Unit) {
    val configuration = LocalConfiguration.current
    val expandedHeight = (configuration.screenHeightDp/1.5).dp
    val collapsedHeight = 160.dp
    var sheetOffset by remember { mutableStateOf(collapsedHeight) }

    val animatedHeight by animateDpAsState(
        targetValue = sheetOffset
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        DraggableBottomSheet(
            sheetHeight = animatedHeight,
            onDrag = { drag ->
                if(drag=="Up"){
                    onSheetStateChange(SheetValue.Expanded)
                    sheetOffset = expandedHeight
                }else{
                    onSheetStateChange(SheetValue.Hidden)
                    sheetOffset = collapsedHeight
                }

            },
            itemDetail = itemDetail
        )
    }
}

@Composable
fun DraggableBottomSheet(
    sheetHeight: Dp,
    onDrag: (String) -> Unit,
    itemDetail: ItemDetail
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(sheetHeight)
            .background(
                brush = Brush.linearGradient(
                    start = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
                    end = Offset.Zero,
                    colors = listOf(
                        BikeShoppingTheme.colors.cardColor2.copy(alpha = 0.3F),
                        BikeShoppingTheme.colors.cardColor1.copy(alpha = 0.3F),
                    )
                ),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .height(sheetHeight)
                .background(
                    brush = Brush.verticalGradient(
                        colors = BikeShoppingTheme.colors.cardGradient
                    ),
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                )
                .draggable(
                    orientation = Orientation.Vertical,
                    state = rememberDraggableState { delta ->
                        if (delta > 0) {
                            onDrag("Down")
                        } else {
                            onDrag("Up")
                        }
                    }
                )
        ) {
            BottomSheetContent(itemDetail = itemDetail,modifier = Modifier.padding(16.dp))
        }
    }


}

@Composable
fun BottomSheetContent(itemDetail: ItemDetail,modifier: Modifier = Modifier) {
    var tab by remember {
        mutableStateOf("Description")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = modifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 45.dp, vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                if (tab=="Description"){
                    BikeDropShadowButton(
                        width = 142.dp,
                        height = 53.dp,
                        onClick = {

                        },
                        text = stringResource(id = R.string.description)
                    )
                    BikeInnerShadowButton(
                        width = 142.dp,
                        height = 53.dp,
                        onClick = {
                            tab = "Specification"
                        },
                        text = stringResource(id = R.string.specification)
                    )
                }else{
                    BikeInnerShadowButton(
                        width = 142.dp,
                        height = 53.dp,
                        onClick = {
                            tab = "Description"
                        },
                        text = stringResource(id = R.string.description)
                    )

                    BikeDropShadowButton(
                        width = 142.dp,
                        height = 53.dp,
                        onClick = {
                        },
                        text = stringResource(id = R.string.specification)
                    )
                }
            }


            Text(
                text = itemDetail.title,
                style = Typography.titleLarge,
                modifier = Modifier.padding(vertical = 15.dp)
            )

            Text(
                text = itemDetail.description,
                color = Color.White.copy(alpha = 0.6f),
                style = Typography.labelSmall.copy(
                    lineHeight = 2.em
                ),
                modifier = Modifier.padding(vertical = 15.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(
                    brush = Brush.linearGradient(
                        start = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
                        end = Offset.Zero,
                        colors = listOf(
                            BikeShoppingTheme.colors.cardColor2.copy(alpha = 0.3F),
                            BikeShoppingTheme.colors.cardColor1.copy(alpha = 0.3F),
                        )
                    ),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .height(120.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = BikeShoppingTheme.colors.cardGradient
                        ),
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 35.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = Helper.formatPrice(itemDetail.price),
                        style = Typography.labelSmall.copy(
                            fontSize = 24.sp,
                            color = BikeShoppingTheme.colors.bottomSheetText
                        ),
                    )
                    AddCartBtn()
                }
            }
        }
    }
}

@Composable
fun AddCartBtn(){
    Box(
        modifier = Modifier
            .width(167.dp)
            .height(50.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = BikeShoppingTheme.colors.blueGradient,
                ),
                shape = RoundedCornerShape(10.dp),
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.addToCart),
            style = Typography.labelMedium.copy(fontSize = 15.sp),
            color = Color.White
        )

    }
}




