package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.ui.theme.BikeShoppingTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BikeScaffold(
    modifier: Modifier = Modifier,
    bottomBar: @Composable (() -> Unit) = {},
    backgroundColor: Color = BikeShoppingTheme.colors.uiBackground,
    content: @Composable (PaddingValues) -> Unit
){
    Scaffold(
        modifier = modifier,
        bottomBar = bottomBar,
        containerColor = backgroundColor,
        content = content,

    )
}