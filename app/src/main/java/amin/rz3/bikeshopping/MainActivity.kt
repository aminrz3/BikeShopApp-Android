package amin.rz3.bikeshopping

import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.ui.screens.bike.bicycle.BikeSections
import amin.rz3.bikeshopping.ui.screens.bike.bicycle.addBikeGraph
import amin.rz3.bikeshopping.ui.components.BikeBackground
import amin.rz3.bikeshopping.ui.components.BikeScaffold
import amin.rz3.bikeshopping.ui.components.NavBar
import amin.rz3.bikeshopping.ui.screens.itemdetail.ItemDetailContainer
import amin.rz3.bikeshopping.ui.screens.itemdetail.nonSpatialExpressiveSpring
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
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            BikeShoppingTheme {
                    val bikeNavController = rememberBikeNavController()
                    val navController = rememberNavController()
                    val visibilityNavBar = remember { mutableStateOf(true) }
                BikeScaffold(
                    bottomBar = {
                        AnimatedVisibility(
                            visible = visibilityNavBar.value,
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
                        ) {
                            NavBar(
                                navController = navController
                            )
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    BikeBackground {
                        NavHost(
                            navController = bikeNavController.navController,
                            startDestination = MainDestinations.BIKE_ROUTE
                        ) {
                            composable(
                                route = MainDestinations.BIKE_ROUTE
                            ) { backStackEntry ->
                                MainContainer(
                                    onItemSelected = { itemDetail, from ->
                                        visibilityNavBar.value = false
                                        bikeNavController.navigateToItemDetail(
                                            itemDetail,
                                            from
                                        )
                                    },
                                    navController = navController
                                )
                            }
                            composable(
                                route = "${MainDestinations.ITEM_DETAIL_ROUTE}?" +
                                        "data={${MainDestinations.ITEM_DETAIL_DATA}}",
                                arguments = listOf(
                                    navArgument(name = MainDestinations.ITEM_DETAIL_DATA) {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                ),
                            ) { backStackEntry ->
                                val arguments = requireNotNull(backStackEntry.arguments)
                                val data =
                                    arguments.getString(MainDestinations.ITEM_DETAIL_DATA)
                                val itemDetail = Gson().fromJson(data, ItemDetail::class.java)
                                ItemDetailContainer(
                                    visibilityBottomSheet = !visibilityNavBar.value,
                                    itemDetail = itemDetail,
                                    upPress = {
                                        visibilityNavBar.value = true
                                        bikeNavController.upPress()
                                    },
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
        onItemSelected: (ItemDetail, NavBackStackEntry) -> Unit,
        navController: NavHostController
    ) {
        NavHost(
            navController = navController,
            startDestination = BikeSections.BICYCLE_ROUTE
        ) {
            addBikeGraph(
                onItemSelected = onItemSelected,
            )
        }
    }
}
