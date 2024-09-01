package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.data.models.itemsMap
import amin.rz3.bikeshopping.ui.bike.Item
import android.util.Log
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
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun Tab(pagerState:PagerState){

    val coroutineScope = rememberCoroutineScope()

    val tabs = listOf(
        TabItem("All", null, 10.dp),
        TabItem(null, R.drawable.battery_tab, (-5).dp),
        TabItem(null, R.drawable.road_tab, (-20).dp),
        TabItem(null, R.drawable.mountion_tab, (-35).dp),
        TabItem(null, R.drawable.accessory_tab, (-50).dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 35.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        tabs.forEachIndexed { index, tab ->
            SquareButton(
                modifier = Modifier.offset(y = tab.offsetY),
                isEnable = pagerState.currentPage == index,
                onClick = {
                    if (pagerState.currentPage != index) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                },
                text = tab.text,
                image = tab.image
            )
        }
    }
}

data class TabItem(val text: String?, val image: Int?, val offsetY: Dp)

