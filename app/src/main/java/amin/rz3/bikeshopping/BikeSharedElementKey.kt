package amin.rz3.bikeshopping

data class BikeSharedElementKey(
    val index: Int,
    val currentPage: Int,
    val type: BikeSharedElementType
)


enum class BikeSharedElementType {
    Background,
    Image,
}

object FilterSharedElementKey