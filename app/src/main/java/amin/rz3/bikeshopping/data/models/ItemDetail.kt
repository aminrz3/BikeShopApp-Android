package amin.rz3.bikeshopping.data.models

import com.google.gson.annotations.SerializedName

data class ItemDetail(
    @SerializedName("id")
    val id:Int,
    @SerializedName("tab")
    val tab:String,
    @SerializedName("img")
    val img:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("subTitle")
    val subTitle:String,
    @SerializedName("specification")
    val specification:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("price")
    val price:String,
    @SerializedName("isFav")
    val isFav:Int,
)
