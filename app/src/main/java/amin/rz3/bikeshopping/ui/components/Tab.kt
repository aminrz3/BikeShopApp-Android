package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.data.models.itemsMap
import amin.rz3.bikeshopping.ui.bike.Item
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun Tab(onClick: (Int,Int) -> Unit){
    val pagerState = rememberPagerState(pageCount = {
        5
    })
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 35.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ){
            SquareButton(
                modifier = Modifier.offset(y = 10.dp),
                isEnable = pagerState.currentPage==0,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(0)
                    }
                },
                text = "All"
            )
            SquareButton(
                modifier = Modifier.offset(y = (-5).dp),
                isEnable = pagerState.currentPage==1,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(1)
                    }
                },
                image = R.drawable.battery_tab
            )
            SquareButton(
                modifier = Modifier.offset(y = (-20).dp),
                isEnable = pagerState.currentPage==2,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(2)
                    }
                },
                image = R.drawable.road_tab
            )
            SquareButton(
                modifier = Modifier.offset(y = (-35).dp),
                isEnable = pagerState.currentPage==3,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(3)
                    }
                },
                image = R.drawable.mountion_tab
            )
            SquareButton(
                modifier = Modifier.offset(y = (-50).dp),
                isEnable = pagerState.currentPage==4,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(4)
                    }
                },
                image = R.drawable.accessory_tab,
            )
        }
        HorizontalPager(state = pagerState, modifier = Modifier.wrapContentHeight()) { page ->
            val itemDetailList  = itemsMap[pagerState.currentPage]!!;
            TabView(itemsDetail = itemDetailList, pagerState.currentPage, onClick)
        }
    }
}

@Composable
fun TabView(itemsDetail: List<ItemDetail>,currentPage:Int , onClick: (Int,Int) -> Unit){
    val height = 150*itemsDetail.size
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        userScrollEnabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
    ) {
        itemsIndexed(itemsDetail) { index,item ->
            Item(itemDetail = item, onClick = {
                onClick(currentPage,index)
            })

        }
    }
}