@file:OptIn(
    ExperimentalSharedTransitionApi::class
)

package amin.rz3.bikeshopping

import amin.rz3.bikeshopping.ui.bike.BikeSections
import amin.rz3.bikeshopping.ui.bike.addBikeGraph
import amin.rz3.bikeshopping.ui.bike.composableWithCompositionLocal
import amin.rz3.bikeshopping.ui.components.BikeBackground
import amin.rz3.bikeshopping.ui.components.BikeScaffold
import amin.rz3.bikeshopping.ui.components.NavBar
import amin.rz3.bikeshopping.ui.itemdetail.ItemDetailContainer
import amin.rz3.bikeshopping.ui.itemdetail.nonSpatialExpressiveSpring
import amin.rz3.bikeshopping.ui.navigation.MainDestinations
import amin.rz3.bikeshopping.ui.navigation.rememberBikeNavController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import amin.rz3.bikeshopping.ui.theme.BikeShoppingTheme
import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            BikeShoppingTheme {
                val bikeNavController = rememberBikeNavController()
                SharedTransitionLayout {
                    CompositionLocalProvider(
                        LocalSharedTransitionScope provides this,
                    ) {
                        NavHost(
                            navController = bikeNavController.navController,
                            startDestination = MainDestinations.BIKE_ROUTE
                        ) {
                            composableWithCompositionLocal(
                                route = MainDestinations.BIKE_ROUTE
                            ) { backStackEntry ->
                                MainContainer(
                                    onItemSelected = bikeNavController::navigateToItemDetail
                                )
                            }
                            composableWithCompositionLocal(
                                route = "${MainDestinations.ITEM_DETAIL_ROUTE}/" +
                                        "{${MainDestinations.CURRENT_PAGE_KEY}}" +
                                        "?index={${MainDestinations.ITEM_DETAIL_INDEX}}",
                                arguments = listOf(
                                    navArgument(MainDestinations.CURRENT_PAGE_KEY) {
                                        type = NavType.IntType
                                    },
                                    navArgument(MainDestinations.ITEM_DETAIL_INDEX) {
                                        type = NavType.IntType
                                    }
                                ),
                            ) { backStackEntry ->
                                val arguments = requireNotNull(backStackEntry.arguments)
                                val currentPage =
                                    arguments.getInt(MainDestinations.CURRENT_PAGE_KEY)
                                val index =
                                    arguments.getInt(MainDestinations.ITEM_DETAIL_INDEX)
                                ItemDetailContainer(
                                    currentPage = currentPage,
                                    index = index,
                                    upPress = bikeNavController::upPress
                                )
                            }
                        }
                    }

                }
            }
        }
    }

    @Composable
    fun MainContainer(
        onItemSelected: (Int, Int, NavBackStackEntry) -> Unit
    ) {

        val sharedTransitionScope = LocalSharedTransitionScope.current
            ?: throw IllegalStateException("No Scope found")
        val animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current
            ?: throw IllegalStateException("No Scope found")
        val bikeNavController = rememberBikeNavController()
        BikeScaffold(
            bottomBar = {
                with(sharedTransitionScope){
                    with(animatedVisibilityScope){
                        NavBar(
                            modifier = Modifier
                                .renderInSharedTransitionScopeOverlay(
                                    zIndexInOverlay = 1f,
                                )
                                .animateEnterExit(
                                    enter = fadeIn(nonSpatialExpressiveSpring()) + slideInVertically(
                                        nonSpatialExpressiveSpring()
                                    ) {
                                        it
                                    },
                                    exit = fadeOut(nonSpatialExpressiveSpring()) + slideOutVertically(
                                        nonSpatialExpressiveSpring()
                                    ) {
                                        it
                                    }
                                ),
                            navController = bikeNavController.navController
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxSize()
        ) {
            BikeBackground {
                NavHost(
                    navController = bikeNavController.navController,
                    startDestination = BikeSections.BICYCLE_ROUTE
                ) {
                    addBikeGraph(
                        onItemSelected = onItemSelected,
                    )
                }
            }
        }
    }
}

val LocalNavAnimatedVisibilityScope = compositionLocalOf<AnimatedVisibilityScope?> { null }
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope?> { null }
