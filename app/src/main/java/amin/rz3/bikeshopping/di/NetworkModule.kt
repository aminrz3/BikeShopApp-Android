package amin.rz3.bikeshopping.di

import amin.rz3.bikeshopping.data.ApiUrl
import amin.rz3.bikeshopping.data.datasource.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Provides BaseUrl as string
     */
    @Singleton
    @Provides
    fun provideBaseUrl(): String = ApiUrl.BASE_URL


    /**
     * Provides HttpLoggingInterceptor for api information
     */
    @Singleton
    @Provides
    fun provideLoggingInterceptor():HttpLoggingInterceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    /**
     * Provides Custom Okhttp
     */
    @Singleton
    @Provides
    fun provideCustomOkhttp(loggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        val okHttpClient = OkHttpClient().newBuilder()

        okHttpClient.callTimeout(40, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(40, TimeUnit.SECONDS)
        okHttpClient.readTimeout(40, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(40, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(loggingInterceptor)
        okHttpClient.build()
        return okHttpClient.build()
    }

    /**
     * Provides ConverterFactory for retrofit
     */
    @Singleton
    @Provides
    fun provideGsonConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    /**
     * Provides ApiService client for retrofit
     */
    @Singleton
    @Provides
    fun provideRetrofitClient(
        baseUrl:String,
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ):Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    /**
     * Provides ApiService using retrofit
     */
    @Singleton
    @Provides
    fun provideRestApiService(retrofit: Retrofit): ApiService =retrofit.create(ApiService::class.java)

}