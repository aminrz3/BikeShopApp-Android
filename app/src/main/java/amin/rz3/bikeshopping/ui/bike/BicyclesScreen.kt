package amin.rz3.bikeshopping.ui.bike

import amin.rz3.bikeshopping.LocalNavAnimatedVisibilityScope
import amin.rz3.bikeshopping.LocalSharedTransitionScope
import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.data.models.itemsMap
import amin.rz3.bikeshopping.ui.components.Banner
import amin.rz3.bikeshopping.ui.components.Header
import amin.rz3.bikeshopping.ui.components.Tab
import amin.rz3.bikeshopping.ui.components.TabView
import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController

@OptIn(ExperimentalSharedTransitionApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BicyclesScreen(onClick: (Int,Int) -> Unit) {
    val pagerState = rememberPagerState(pageCount = {
        5
    })
    val itemDetailList = remember { itemsMap[pagerState.currentPage] ?: emptyList() }
    val height = 150*itemDetailList.size
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
            }
            item {
                Banner()
            }
            item {
                Tab(pagerState = pagerState)
            }
            item {
                TabView(pagerState = pagerState, height = height, itemDetailList = itemDetailList, onClick = onClick)
            }
        }


}