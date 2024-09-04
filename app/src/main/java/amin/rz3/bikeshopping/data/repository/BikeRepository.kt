package amin.rz3.bikeshopping.data.repository

import amin.rz3.bikeshopping.data.datasource.remote.ApiService
import amin.rz3.bikeshopping.data.models.Banner
import amin.rz3.bikeshopping.data.models.ShopItems
import amin.rz3.bikeshopping.ui.commons.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BikeRepository @Inject constructor(
    private val apiService: ApiService
):BikeRepositoryInterface {
    override suspend fun bannersList(): Flow<DataState<List<Banner>>> = flow {
        emit(DataState.Loading)
        try {
            val bannerList = apiService.bannersList()
            emit(DataState.Success(bannerList))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }

    override suspend fun shopItems(): Flow<DataState<ShopItems>> = flow {
        emit(DataState.Loading)
        try {
            val shopItemList = apiService.shopItemsList()
            emit(DataState.Success(shopItemList))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}