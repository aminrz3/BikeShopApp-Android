package amin.rz3.bikeshopping.data.models

import com.google.gson.annotations.SerializedName

data class ShopItems(
    @SerializedName("all")
    val all: List<ItemDetail>,
    @SerializedName("accessoryTab")
    val accessoryTab: List<ItemDetail>,
    @SerializedName("roadTab")
    val roadTab: List<ItemDetail>,
    @SerializedName("mountionTab")
    val mountionTab: List<ItemDetail>,
    @SerializedName("helmetTab")
    val helmetTab: List<ItemDetail>,
){
    fun toMap(): Map<Int, List<ItemDetail>> {
        return mapOf(
            0 to all,
            1 to accessoryTab,
            2 to roadTab,
            3 to mountionTab,
            4 to helmetTab
        )
    }
}

//val shopItems = ShopItems(
//    all = listOf(
//    all = listOf(
//        ItemDetail(
//            id = 1,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 2,
//            img = R.drawable.helmet,
//            title = "SMITH - Trade",
//            subTitle = "Road Helmet",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 8500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 3,
//            img = R.drawable.bike2,
//            title = "PILOT - Chromoly ",
//            subTitle = "Mountain Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 10500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 4,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 5,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 6,
//            img = R.drawable.helmet,
//            title = "SMITH - Trade",
//            subTitle = "Road Helmet",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 8500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 7,
//            img = R.drawable.bike2,
//            title = "PILOT - Chromoly ",
//            subTitle = "Mountain Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 10500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 8,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        )
//    ),
//    accessoryTab = listOf(
//        ItemDetail(
//            id = 1,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 2,
//            img = R.drawable.helmet,
//            title = "SMITH - Trade",
//            subTitle = "Road Helmet",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 8500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 3,
//            img = R.drawable.bike2,
//            title = "PILOT - Chromoly ",
//            subTitle = "Mountain Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 10500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 4,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        )
//    ),
//    roadTab = listOf(
//        ItemDetail(
//            id = 1,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 2,
//            img = R.drawable.helmet,
//            title = "SMITH - Trade",
//            subTitle = "Road Helmet",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 8500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 3,
//            img = R.drawable.bike2,
//            title = "PILOT - Chromoly ",
//            subTitle = "Mountain Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 10500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 4,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        )
//    ),
//    mountionTab = listOf(
//        ItemDetail(
//            id = 1,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 2,
//            img = R.drawable.helmet,
//            title = "SMITH - Trade",
//            subTitle = "Road Helmet",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 8500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 3,
//            img = R.drawable.bike2,
//            title = "PILOT - Chromoly ",
//            subTitle = "Mountain Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 10500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 4,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        )
//    ),
//    helmetTab = listOf(
//        ItemDetail(
//            id = 1,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 2,
//            img = R.drawable.helmet,
//            title = "SMITH - Trade",
//            subTitle = "Road Helmet",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 8500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 3,
//            img = R.drawable.bike2,
//            title = "PILOT - Chromoly ",
//            subTitle = "Mountain Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 10500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        ),
//        ItemDetail(
//            id = 4,
//            img = R.drawable.bike,
//            title = "PEUGEOT - LR01",
//            subTitle = "Road Bike",
//            description = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//            isFav = false,
//            price = 7500,
//            specification = "The LR01 uses the same design as the most iconic bikes from PEUGEOT Cycles' 130-year history and combines it with agile, dynamic performance that's perfectly suited to navigating today's cities. As well as a lugged steel frame and iconic PEUGEOT black-and-white chequer design, this city bike also features a 16-speed Shimano Claris drivetrain.",
//        )
//    ),
//)


//val itemsMap = mapOf(
//    0 to shopItems.all,
//    1 to shopItems.accessoryTab,
//    2 to shopItems.roadTab,
//    3 to shopItems.mountionTab,
//    4 to shopItems.helmetTab
//)