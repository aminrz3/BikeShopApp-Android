package amin.rz3.bikeshopping.ui.screens.bike.bicycle

import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.ui.screens.bike.cart.CartScreen
import amin.rz3.bikeshopping.ui.screens.bike.docs.DocsScreen
import amin.rz3.bikeshopping.ui.screens.bike.map.MapScreen
import amin.rz3.bikeshopping.ui.screens.bike.profile.ProfileScreen
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.addBikeGraph(
    onItemSelected: (ItemDetail,  NavBackStackEntry) -> Unit,
) {
    composable(BikeSections.BICYCLE_ROUTE) { from ->
        BicyclesScreen(
            onClick = { itemDetail ->
                onItemSelected(
                    itemDetail,
                    from
                )
            },
        )
    }
    composable(BikeSections.MAP_ROUTE) { from ->
        MapScreen()
    }
    composable(BikeSections.CART_ROUTE) { from ->
        CartScreen()
    }
    composable(BikeSections.PROFILE_ROUTE) {
        ProfileScreen()
    }
    composable(BikeSections.DOCS_ROUTE) {
        DocsScreen()
    }
}


object BikeSections {
    const val BICYCLE_ROUTE = "bicycles"
    const val MAP_ROUTE = "map"
    const val CART_ROUTE = "cart"
    const val PROFILE_ROUTE = "profile"
    const val DOCS_ROUTE = "docs"
}