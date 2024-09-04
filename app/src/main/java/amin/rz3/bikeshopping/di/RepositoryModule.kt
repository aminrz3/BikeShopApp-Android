package amin.rz3.bikeshopping.di

import amin.rz3.bikeshopping.data.datasource.remote.ApiService
import amin.rz3.bikeshopping.data.repository.BikeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideBikeRepository(
        apiService: ApiService
    ) = BikeRepository(apiService)
}