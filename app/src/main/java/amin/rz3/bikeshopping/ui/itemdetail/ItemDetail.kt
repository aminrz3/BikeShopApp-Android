@file:OptIn(ExperimentalSharedTransitionApi::class)

package amin.rz3.bikeshopping.ui.itemdetail

import amin.rz3.bikeshopping.BikeSharedElementKey
import amin.rz3.bikeshopping.BikeSharedElementType
import amin.rz3.bikeshopping.LocalNavAnimatedVisibilityScope
import amin.rz3.bikeshopping.LocalSharedTransitionScope
import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.data.models.itemsMap
import amin.rz3.bikeshopping.ui.components.BikeBackground
import amin.rz3.bikeshopping.ui.components.BikeScaffold
import amin.rz3.bikeshopping.ui.components.Header
import amin.rz3.bikeshopping.ui.theme.BikeShoppingTheme
import androidx.compose.animation.BoundsTransform
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

@Composable
fun ItemDetailContainer(currentPage: Int, index: Int, upPress: () -> Unit) {
    val itemDetail = remember(currentPage, index) {
        itemsMap[currentPage]!![index]
    }
    val sharedTransitionScope = LocalSharedTransitionScope.current
        ?: throw IllegalStateException("No Scope found")
    val animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current
        ?: throw IllegalStateException("No Scope found")


    with(sharedTransitionScope) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = BikeShoppingTheme.colors.uiBackground)
                .sharedBounds(
                rememberSharedContentState(
                    key = BikeSharedElementKey(
                        id = itemDetail.id,
                        type = BikeSharedElementType.Background
                    )
                ),
                animatedVisibilityScope,
                boundsTransform = bikeDetailBoundsTransform,
                exit = fadeOut(nonSpatialExpressiveSpring()),
                enter = fadeIn(nonSpatialExpressiveSpring()),
            ),
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
                        .sharedBounds(
                            rememberSharedContentState(
                                key = BikeSharedElementKey(
                                    id = itemDetail.id,
                                    type = BikeSharedElementType.Image
                                )
                            ),
                            animatedVisibilityScope = animatedVisibilityScope,
                            exit = fadeOut(nonSpatialExpressiveSpring()),
                            enter = fadeIn(nonSpatialExpressiveSpring()),
                            boundsTransform = bikeDetailBoundsTransform
                        )
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = itemDetail.img),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 15.dp)
                    )
                }
            }
        }
    }
}