package amin.rz3.bikeshopping.ui.screens.bike.bicycle

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.data.models.Banner
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.data.models.ShopItems
import amin.rz3.bikeshopping.ui.commons.DataState
import amin.rz3.bikeshopping.ui.components.Banner
import amin.rz3.bikeshopping.ui.components.Header
import amin.rz3.bikeshopping.ui.components.Tab
import amin.rz3.bikeshopping.ui.components.TabView
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "MutableCollectionMutableState")
@Composable
fun BicyclesScreen(onClick: (ItemDetail) -> Unit) {
    val bicycleViewModel = hiltViewModel<BicycleViewModel>()
    val pagerState = rememberPagerState(pageCount = {
        5
    })
    val bannerList = remember {
        mutableStateOf(arrayListOf<Banner>())
    }

    val shopItems =  bicycleViewModel.shopItems.collectAsState()
    val currentPageItems = remember {
        derivedStateOf {
            shopItems.value?.toMap()?.get(pagerState.currentPage) ?: emptyList()
        }
    }
    val height = remember {
        derivedStateOf {
            150*currentPageItems.value.size
        }
    }

    LaunchedEffect(key1 = 0) {
        bicycleViewModel.getBanners()
        bicycleViewModel.getShopItems()
    }

    if(bicycleViewModel.banners.value is DataState.Success<List<Banner>>){
        bannerList.value = (bicycleViewModel.banners.value as DataState.Success<List<Banner>>).data as ArrayList
    }
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
                Banner(banners = bannerList.value)
            }
            item {
                Tab(pagerState = pagerState)
            }
            item {
                TabView(
                    pagerState = pagerState,
                    height = height.value,
                    itemDetailList = currentPageItems.value,
                    onClick = onClick
                )

            }
        }


}