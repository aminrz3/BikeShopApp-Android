package amin.rz3.bikeshopping.ui.screens.itemdetail

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.ui.components.BikeBottomSheet
import amin.rz3.bikeshopping.ui.components.Header
import amin.rz3.bikeshopping.ui.theme.BikeShoppingTheme
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest



fun <T> nonSpatialExpressiveSpring() = spring<T>(
    dampingRatio = 1f,
    stiffness = 1600f
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailContainer(visibilityBottomSheet:Boolean, itemDetail: ItemDetail, upPress: () -> Unit) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    var bottomSheetState by remember { mutableStateOf(SheetValue.Hidden) }

    val imageSize by animateDpAsState(
        targetValue = if (bottomSheetState == SheetValue.Expanded) screenHeight.dp - (screenHeight/1.2).dp else screenHeight.dp - 200.dp,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BikeShoppingTheme.colors.uiBackground)
    ) {
        Column {
            Header(
                text = itemDetail.title,
                image = R.drawable.back,
                onClick = upPress,
                reverseDirection = true
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(itemDetail.img)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(imageSize)
                        .padding(horizontal = 15.dp)
                )
            }
            BikeBottomSheet(
                itemDetail = itemDetail,
                onSheetStateChange = { state ->
                    bottomSheetState = state
                },
            )
        }

    }
}

