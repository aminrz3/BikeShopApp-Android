package amin.rz3.bikeshopping.ui.screens.bike.bicycle

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.ui.commons.Helper
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.ui.components.BikeCard
import amin.rz3.bikeshopping.ui.theme.Typography
import androidx.compose.animation.ExperimentalSharedTransitionApi
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun Item(
   itemDetail: ItemDetail, onClick: () -> Unit,
) {
    var isTransitioning by remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    val itemSize = remember(configuration.screenWidthDp) {
        (configuration.screenWidthDp.dp / 2)
    }
    val paddingTop = if (itemDetail.id % 2 == 0) 0.dp else 25.dp
    Box(
        modifier = Modifier
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    isTransitioning = true
                    onClick()
                }
            )
            .width(itemSize)
            .padding(start = 15.dp, end = 15.dp, top = paddingTop)
            .height(241.dp)
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
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
                .align(alignment = Alignment.Center)
                .padding(bottom = 50.dp, start = 25.dp, end = 25.dp)
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
            text = Helper.formatPrice(itemDetail.price.toInt()),
            style = Typography.labelMedium.copy(
                color = Color.White.copy(0.6f)
            ),
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .padding(bottom = 25.dp, start = 15.dp)
        )


    }
}