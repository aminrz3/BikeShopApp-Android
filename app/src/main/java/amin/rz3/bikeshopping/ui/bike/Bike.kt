package amin.rz3.bikeshopping.ui.bike

import amin.rz3.bikeshopping.LocalNavAnimatedVisibilityScope
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.ui.bike.cart.CartScreen
import amin.rz3.bikeshopping.ui.bike.docs.DocsScreen
import amin.rz3.bikeshopping.ui.bike.map.MapScreen
import amin.rz3.bikeshopping.ui.bike.profile.ProfileScreen
import amin.rz3.bikeshopping.ui.itemdetail.nonSpatialExpressiveSpring
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.composableWithCompositionLocal(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    enterTransition: (
    @JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?
    )? = {
        fadeIn(nonSpatialExpressiveSpring())
    },
    exitTransition: (
    @JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?
    )? = {
        fadeOut(nonSpatialExpressiveSpring())
    },
    popEnterTransition: (
    @JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?
    )? =
        enterTransition,
    popExitTransition: (
    @JvmSuppressWildcards
    AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?
    )? =
        exitTransition,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route,
        arguments,
        deepLinks,
        enterTransition,
        exitTransition,
        popEnterTransition,
        popExitTransition
    ) {
        CompositionLocalProvider(
            LocalNavAnimatedVisibilityScope provides this@composable
        ) {
            content(it)
        }
    }
}

fun NavGraphBuilder.addBikeGraph(
    onItemSelected: (Int, Int, NavBackStackEntry) -> Unit,
) {
    composable(BikeSections.BICYCLE_ROUTE) { from ->
        BicyclesScreen(
            onClick = { currentPage, index ->
                onItemSelected(
                    currentPage,
                    index,
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