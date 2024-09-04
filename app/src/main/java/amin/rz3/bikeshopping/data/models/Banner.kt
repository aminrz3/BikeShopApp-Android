package amin.rz3.bikeshopping.data.models

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("id")
    val id:Int,
    @SerializedName("image")
    val image:String,
    @SerializedName("text")
    val text:String
)