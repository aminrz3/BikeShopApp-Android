package amin.rz3.bikeshopping

data class BikeSharedElementKey(
    val id: Int,
    val type: BikeSharedElementType
)


enum class BikeSharedElementType {
    Background,
    Image,
}