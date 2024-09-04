package amin.rz3.bikeshopping.data.repository

import amin.rz3.bikeshopping.data.models.Banner
import amin.rz3.bikeshopping.data.models.ShopItems
import amin.rz3.bikeshopping.ui.commons.DataState
import kotlinx.coroutines.flow.Flow

interface BikeRepositoryInterface {
    suspend fun bannersList(): Flow<DataState<List<Banner>>>
    suspend fun shopItems(): Flow<DataState<ShopItems>>
}