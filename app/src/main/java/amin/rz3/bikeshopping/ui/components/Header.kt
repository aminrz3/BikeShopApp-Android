package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.ui.theme.Typography
import amin.rz3.bikeshopping.ui.theme.blueGradient1
import amin.rz3.bikeshopping.ui.theme.blueGradient2
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    modifier: Modifier = Modifier,
    text:String,
    image:Int,
    onClick:()->Unit,
    reverseDirection:Boolean = false
){
    Row(
        modifier = modifier
            .statusBarsPadding()
            .padding(top = 15.dp)
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if(reverseDirection){
            SquareButton(
                onClick = onClick,
                image = image,
                size = 44.dp,
                shadowElevationDp = 8.dp
            )
            Text(
                text = text,
                style = Typography.titleLarge
            )
            Spacer(modifier = Modifier.padding(start = 15.dp))
        }else{
            Text(
                text = text,
                style = Typography.titleLarge,
            )
            SquareButton(
                onClick = onClick,
                image = image,
                size = 44.dp,
                shadowElevationDp = 8.dp
            )

        }

    }
}