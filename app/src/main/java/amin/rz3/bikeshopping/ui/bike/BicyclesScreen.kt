package amin.rz3.bikeshopping.ui.bike

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.ui.components.Banner
import amin.rz3.bikeshopping.ui.components.Header
import amin.rz3.bikeshopping.ui.components.Tab
import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BicyclesScreen(onClick: (Int,Int) -> Unit) {


    val visibleScreen = remember { mutableStateOf(true) }

    AnimatedContent(
        targetState = visibleScreen.value,
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }) + fadeIn() togetherWith
                    slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth }) + fadeOut()
        }
    ){ targetVisible ->
        if (targetVisible) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    Header(
                        text = stringResource(id = R.string.ChooseYourBike),
                        image = R.drawable.search,
                        onClick = {}
                    )
                    Banner()
                }
                item {
                    Tab(onClick)
                }
            }
        }
    }

}