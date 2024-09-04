package amin.rz3.bikeshopping.ui.screens.bike.bicycle

import amin.rz3.bikeshopping.data.models.Banner
import amin.rz3.bikeshopping.data.models.ItemDetail
import amin.rz3.bikeshopping.data.models.ShopItems
import amin.rz3.bikeshopping.data.repository.BikeRepository
import amin.rz3.bikeshopping.ui.commons.DataState
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BicycleViewModel @Inject constructor(private val bikeRepository: BikeRepository) :
    ViewModel() {
    val banners: MutableState<DataState<List<Banner>>?> = mutableStateOf(null)
    private val _shopItems = MutableStateFlow<ShopItems?>(null)
    val shopItems get() = _shopItems.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading get() = _isLoading.asStateFlow()


    fun getBanners() {
        viewModelScope.launch {
            bikeRepository.bannersList().collect {
                banners.value = it
            }
        }
    }

    fun getShopItems() {
        viewModelScope.launch {
            bikeRepository.shopItems().collect {
                when (it) {
                    is DataState.Loading -> {
                        _isLoading.value = true
                    }

                    is DataState.Success -> {
                        _shopItems.value = it.data
                        _isLoading.value = false
                    }

                    is DataState.Error -> {
                        _isLoading.value = false
                    }
                }
            }
        }
    }

}