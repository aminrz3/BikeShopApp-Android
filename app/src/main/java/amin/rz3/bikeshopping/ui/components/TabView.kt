package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.ui.screens.bike.bicycle.Item
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TabView(pagerState:PagerState,height:Int, itemDetailList:List<ItemDetail>,onClick: (ItemDetail) -> Unit){

    HorizontalPager(state = pagerState) { page ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            userScrollEnabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp)
        ) {
            itemsIndexed(itemDetailList) { index, item ->
                Item(itemDetail = item,onClick = {
                    onClick(item)
                })
            }
        }
    }


}