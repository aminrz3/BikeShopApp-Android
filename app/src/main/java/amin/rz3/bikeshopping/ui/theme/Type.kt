package amin.rz3.bikeshopping.ui.theme

import amin.rz3.bikeshopping.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val BikeFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = BikeFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = TextColor
    ),

    labelMedium = TextStyle(
        fontFamily = BikeFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        color = TextColor
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

