package amin.rz3.bikeshopping.data.datasource.remote

import amin.rz3.bikeshopping.data.models.Banner
import amin.rz3.bikeshopping.data.models.ShopItems
import retrofit2.http.GET

interface ApiService {
    @GET("Banners")
    suspend fun bannersList():List<Banner>
    @GET("ShopItems")
    suspend fun shopItemsList():ShopItems
}