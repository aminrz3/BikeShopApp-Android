package amin.rz3.bikeshopping.data.models

import amin.rz3.bikeshopping.R
import android.os.Parcelable
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

data class ShopItems(
    val all: List<ItemDetail>,
    val accessoryTab: List<ItemDetail>,
    val roadTab: List<ItemDetail>,
    val mountionTab: List<ItemDetail>,
    val helmetTab: List<ItemDetail>,
)

data class ItemDetail(
    val id:Int,
    val img:Int,
    val title:String,
    val subTitle:String,
    val specification:String,
    val description:String,
    val price:Int,
    val isFav:Boolean,
)
class ShopItemsProvider : PreviewParameterProvider<ShopItems> {
    override val values = sequenceOf(
        ShopItems(
            all = listOf(
                ItemDetail(
                    id = 1,
                    img = R.drawable.bike,
                    title = "PEUGEOT - LR01",
                    subTitle = "Road Bike",
                    specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
                    description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
                    price = 7200,
                    isFav = false,
                )
            ),
            accessoryTab = listOf(
                ItemDetail(
                    id = 1,
                    img = R.drawable.bike,
                    title = "PEUGEOT - LR01",
                    subTitle = "Road Bike",
                    specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
                    description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
                    price = 7200,
                    isFav = false,
                )
            ),
            roadTab = emptyList(),
            mountionTab = emptyList(),
            helmetTab = emptyList(),
        ),
    )
}


val shopItems = ShopItems(
    all = listOf(
        ItemDetail(
            id = 1,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        ),
        ItemDetail(
            id = 2,
            img = R.drawable.helmet,
            title = "SMITH - Trade",
            subTitle = "Road Helmet",
            description = "",
            isFav = false,
            price = 8500,
            specification = "",
        ),
        ItemDetail(
            id = 3,
            img = R.drawable.bike2,
            title = "PILOT - Chromoly ",
            subTitle = "Mountain Bike",
            description = "",
            isFav = false,
            price = 10500,
            specification = "",
        ),
        ItemDetail(
            id = 4,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        ),
        ItemDetail(
            id = 5,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        ),
        ItemDetail(
            id = 6,
            img = R.drawable.helmet,
            title = "SMITH - Trade",
            subTitle = "Road Helmet",
            description = "",
            isFav = false,
            price = 8500,
            specification = "",
        ),
        ItemDetail(
            id = 7,
            img = R.drawable.bike2,
            title = "PILOT - Chromoly ",
            subTitle = "Mountain Bike",
            description = "",
            isFav = false,
            price = 10500,
            specification = "",
        ),
        ItemDetail(
            id = 8,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        )
    ),
    accessoryTab = listOf(
        ItemDetail(
            id = 1,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        ),
        ItemDetail(
            id = 2,
            img = R.drawable.helmet,
            title = "SMITH - Trade",
            subTitle = "Road Helmet",
            description = "",
            isFav = false,
            price = 8500,
            specification = "",
        ),
        ItemDetail(
            id = 3,
            img = R.drawable.bike2,
            title = "PILOT - Chromoly ",
            subTitle = "Mountain Bike",
            description = "",
            isFav = false,
            price = 10500,
            specification = "",
        ),
        ItemDetail(
            id = 4,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        )
    ),
    roadTab = listOf(
        ItemDetail(
            id = 1,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        ),
        ItemDetail(
            id = 2,
            img = R.drawable.helmet,
            title = "SMITH - Trade",
            subTitle = "Road Helmet",
            description = "",
            isFav = false,
            price = 8500,
            specification = "",
        ),
        ItemDetail(
            id = 3,
            img = R.drawable.bike2,
            title = "PILOT - Chromoly ",
            subTitle = "Mountain Bike",
            description = "",
            isFav = false,
            price = 10500,
            specification = "",
        ),
        ItemDetail(
            id = 4,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        )
    ),
    mountionTab = listOf(
        ItemDetail(
            id = 1,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        ),
        ItemDetail(
            id = 2,
            img = R.drawable.helmet,
            title = "SMITH - Trade",
            subTitle = "Road Helmet",
            description = "",
            isFav = false,
            price = 8500,
            specification = "",
        ),
        ItemDetail(
            id = 3,
            img = R.drawable.bike2,
            title = "PILOT - Chromoly ",
            subTitle = "Mountain Bike",
            description = "",
            isFav = false,
            price = 10500,
            specification = "",
        ),
        ItemDetail(
            id = 4,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        )
    ),
    helmetTab = listOf(
        ItemDetail(
            id = 1,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        ),
        ItemDetail(
            id = 2,
            img = R.drawable.helmet,
            title = "SMITH - Trade",
            subTitle = "Road Helmet",
            description = "",
            isFav = false,
            price = 8500,
            specification = "",
        ),
        ItemDetail(
            id = 3,
            img = R.drawable.bike2,
            title = "PILOT - Chromoly ",
            subTitle = "Mountain Bike",
            description = "",
            isFav = false,
            price = 10500,
            specification = "",
        ),
        ItemDetail(
            id = 4,
            img = R.drawable.bike,
            title = "PEUGEOT - LR01",
            subTitle = "Road Bike",
            description = "",
            isFav = false,
            price = 7500,
            specification = "",
        )
    ),
)


val itemsMap = mapOf(
    0 to shopItems.all,
    1 to shopItems.accessoryTab,
    2 to shopItems.roadTab,
    3 to shopItems.mountionTab,
    4 to shopItems.helmetTab
)