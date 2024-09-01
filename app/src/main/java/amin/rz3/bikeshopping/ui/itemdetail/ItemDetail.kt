@file:OptIn(ExperimentalSharedTransitionApi::class)

package amin.rz3.bikeshopping.ui.itemdetail

import amin.rz3.bikeshopping.BikeSharedElementKey
import amin.rz3.bikeshopping.BikeSharedElementType
import amin.rz3.bikeshopping.LocalNavAnimatedVisibilityScope
import amin.rz3.bikeshopping.LocalSharedTransitionScope
import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.data.models.itemsMap
import amin.rz3.bikeshopping.ui.components.BikeBackground
import amin.rz3.bikeshopping.ui.components.BikeBottomSheet
import amin.rz3.bikeshopping.ui.components.BikeScaffold
import amin.rz3.bikeshopping.ui.components.Header
import amin.rz3.bikeshopping.ui.theme.BikeShoppingTheme
import amin.rz3.bikeshopping.ui.theme.Typography
import androidx.compose.animation.BoundsTransform
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

fun <T> spatialExpressiveSpring() = spring<T>(
    dampingRatio = 0.8f,
    stiffness = 380f
)

fun <T> nonSpatialExpressiveSpring() = spring<T>(
    dampingRatio = 1f,
    stiffness = 1600f
)

val bikeDetailBoundsTransform = BoundsTransform { _, _ ->
    spatialExpressiveSpring()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailContainer(currentPage: Int, index: Int, upPress: () -> Unit) {
    val itemDetail = remember(currentPage, index) {
        itemsMap[currentPage]!![index]
    }
    val sharedTransitionScope = LocalSharedTransitionScope.current
        ?: throw IllegalStateException("No Scope found")
    val animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current
        ?: throw IllegalStateException("No Scope found")

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    var bottomSheetState by remember { mutableStateOf(SheetValue.Hidden) }

    val imageSize by animateDpAsState(
        targetValue = if (bottomSheetState == SheetValue.Expanded) screenHeight.dp - (screenHeight / 1.5).dp else screenHeight.dp - 200.dp,
    )

    with(animatedVisibilityScope) {
        with(sharedTransitionScope) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = BikeShoppingTheme.colors.uiBackground)
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
                        enter = fadeIn(nonSpatialExpressiveSpring()),
                    )
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
                        Image(
                            painter = painterResource(id = itemDetail.img),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(imageSize)
                                .sharedBounds(
                                    rememberSharedContentState(
                                        key = BikeSharedElementKey(
                                            index = index,
                                            currentPage = currentPage,
                                            type = BikeSharedElementType.Image
                                        )
                                    ),
                                    animatedVisibilityScope = animatedVisibilityScope,
                                    exit = fadeOut(nonSpatialExpressiveSpring()),
                                    enter = fadeIn(nonSpatialExpressiveSpring()),
                                    boundsTransform = bikeDetailBoundsTransform
                                )
                                .padding(horizontal = 15.dp)
                        )
                    }
                    BikeBottomSheet(
                        itemDetail = itemDetail,
                        onSheetStateChange = { state ->
                            bottomSheetState = state
                        },
                        modifier = Modifier
                            .renderInSharedTransitionScopeOverlay(zIndexInOverlay = 4f)
                            .animateEnterExit(
                                enter = slideInVertically(
                                    tween(
                                        300,
                                        delayMillis = 300
                                    )
                                ) { it } + fadeIn(tween(300, delayMillis = 300)),
                                exit = slideOutVertically(tween(50)) { it } +
                                        fadeOut(tween(50))
                            )
                    )
                }

            }
        }
    }
}

