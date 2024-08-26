package amin.rz3.bikeshopping.ui.components

import amin.rz3.bikeshopping.R
import amin.rz3.bikeshopping.ui.theme.BikeFontFamily
import amin.rz3.bikeshopping.ui.theme.Typography
import amin.rz3.bikeshopping.ui.theme.cardGradient1
import amin.rz3.bikeshopping.ui.theme.cardGradient2
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun Banner() {
    val banners = listOf(
        R.drawable.banner_sample,
        R.drawable.banner_sample,
        R.drawable.banner_sample,
    )
    val state = rememberPagerState(pageCount = {banners.size})
    HorizontalPager(state = state) {img->
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(240.dp)
        ){
            BannerCard()
            Image(
                painter = painterResource(id = banners[img]),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(bottom = 55.dp, top = 25.dp)
                )
            Text(
                text = stringResource(id = R.string.BannerTitle),
                style = Typography.titleLarge.copy(
                    color = Color.White.copy(alpha = 0.6f),
                    fontSize = 26.sp
                ),
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .padding(bottom = 30.dp, start = 15.dp)
            )
        }
    }

}

@Composable
fun BannerCard(){
    val list =  listOf(cardGradient1, cardGradient2)
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val rect = Rect(Offset.Zero, size)

        val path = Path().apply {
            lineTo(size.width, 0f)
            lineTo(size.width, size.height*0.8f)
            lineTo(0f, size.height)
            close()

        }

        val borderPaint = Paint().apply {
            shader = LinearGradientShader(
                rect.topLeft,
                rect.bottomRight,
                listOf(
                    Color.White.copy(alpha = 0.2f),
                    Color.Black.copy(alpha = 0.2f)
                )
            )
            style = PaintingStyle.Stroke
            strokeWidth = 4f // Adjust the border thickness here
            pathEffect = PathEffect.cornerPathEffect(60f)
        }

        val paint =  Paint().apply {
            shader = LinearGradientShader(
                rect.topLeft,
                rect.bottomRight,
                list
            )
            pathEffect = PathEffect.cornerPathEffect(60f)

        }
        drawIntoCanvas { canvas ->
            canvas.drawOutline(
                outline = Outline.Generic(path),
                paint = paint
            )

            canvas.drawOutline(
                outline = Outline.Generic(path),
                paint = borderPaint
            )
        }

    }
}