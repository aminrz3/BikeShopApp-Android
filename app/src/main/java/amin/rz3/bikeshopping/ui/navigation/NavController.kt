package amin.rz3.bikeshopping.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

object MainDestinations {
    const val BIKE_ROUTE = "bike"
    const val CURRENT_PAGE_KEY = "currentPage"
    const val ITEM_DETAIL_INDEX = "index"
    const val ITEM_DETAIL_ROUTE = "ItemDetail"
}

@Composable
fun rememberBikeNavController(
    navController: NavHostController = rememberNavController()
): BikeNavController = remember(navController) {
    BikeNavController(navController)
}

@Stable
class BikeNavController(
    val navController: NavHostController,
){

    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToItemDetail(currentPage: Int, index: Int, from: NavBackStackEntry) {
        if (from.lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
            navController.navigate("${MainDestinations.ITEM_DETAIL_ROUTE}/$currentPage?index=$index")
        }
    }
}