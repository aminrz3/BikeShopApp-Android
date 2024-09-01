package amin.rz3.bikeshopping.ui.bike

import amin.rz3.bikeshopping.BikeSharedElementKey
import amin.rz3.bikeshopping.BikeSharedElementType
import amin.rz3.bikeshopping.LocalNavAnimatedVisibilityScope
import amin.rz3.bikeshopping.LocalSharedTransitionScope
import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.ui.commons.Helper
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.data.models.ShopItemsProvider
import amin.rz3.bikeshopping.ui.components.BikeCard
import amin.rz3.bikeshopping.ui.itemdetail.bikeDetailBoundsTransform
import amin.rz3.bikeshopping.ui.itemdetail.nonSpatialExpressiveSpring
import amin.rz3.bikeshopping.ui.theme.Typography
import amin.rz3.bikeshopping.ui.theme.cardGradient1
import amin.rz3.bikeshopping.ui.theme.cardGradient2
import androidx.annotation.DrawableRes
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Item(
    @PreviewParameter(ShopItemsProvider::class) itemDetail: ItemDetail, index:Int, currentPage:Int, onClick: () -> Unit,
) {
    val configuration = LocalConfiguration.current
    val itemSize = remember(configuration.screenWidthDp) {
        (configuration.screenWidthDp.dp / 2)
    }
    val paddingTop = if (itemDetail.id % 2 == 0) 0.dp else 25.dp
    val sharedTransitionScope = LocalSharedTransitionScope.current
        ?: throw IllegalStateException("No SharedElementScope found")
    val animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current
        ?: throw IllegalStateException("No SharedElementScope found")
    with(sharedTransitionScope) {
        Box(
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onClick
                )
                .width(itemSize)
                .padding(start = 15.dp, end = 15.dp, top = paddingTop)
                .height(241.dp)
                .sharedBounds(
                    rememberSharedContentState(
                        key = BikeSharedElementKey(
                            index = index,
                            currentPage = currentPage,
                            type = BikeSharedElementType.Background
                        )
                    ),
                    animatedVisibilityScope,
                    boundsTransform = bikeDetailBoundsTransform,
                    exit = fadeOut(nonSpatialExpressiveSpring()),
                    enter = fadeIn(nonSpatialExpressiveSpring())
                ),
        ) {

            BikeCard()
            Image(
                painter = painterResource(id = R.drawable.heart_disable),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopEnd)
                    .padding(top = 25.dp, end = 25.dp)
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(itemDetail.img)
                    .crossfade(true)
                    .build(),
                placeholder = debugPlaceholder(debugPreview = R.drawable.helmet),
                contentDescription = "",
                modifier = Modifier.fillMaxSize().sharedBounds(
                    sharedContentState = rememberSharedContentState(
                        key = BikeSharedElementKey(
                            index = index,
                            currentPage = currentPage,
                            type = BikeSharedElementType.Image
                        )
                    ),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = bikeDetailBoundsTransform,
                    enter = fadeIn(nonSpatialExpressiveSpring()),
                    exit = fadeOut(nonSpatialExpressiveSpring())
                )
                    .align(alignment = Alignment.Center)
                    .padding(bottom = 50.dp, start = 25.dp, end = 25.dp),
            )

            Text(
                text = itemDetail.subTitle,
                style = Typography.labelMedium.copy(
                    color = Color.White.copy(0.6f)
                ),
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .padding(bottom = 65.dp, start = 15.dp)
            )
            Text(
                text = itemDetail.title,
                style = Typography.titleLarge.copy(
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .padding(bottom = 45.dp, start = 15.dp)
            )

            Text(
                text = Helper.formatPrice(itemDetail.price),
                style = Typography.labelMedium.copy(
                    color = Color.White.copy(0.6f)
                ),
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .padding(bottom = 25.dp, start = 15.dp)
            )


        }
    }
}

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) =
    if (LocalInspectionMode.current) {
        painterResource(id = debugPreview)
    } else {
        null
    }