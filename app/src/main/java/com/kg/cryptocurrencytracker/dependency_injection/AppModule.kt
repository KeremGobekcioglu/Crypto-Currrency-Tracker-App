package com.kg.cryptocurrencytracker.dependency_injection

import com.kg.cryptocurrencytracker.common.Constants
import com.kg.cryptocurrencytracker.data.remote.CoinPaprikaApi
import com.kg.cryptocurrencytracker.data.repository.CoinRepositoryImpl
import com.kg.cryptocurrencytracker.dependency_injection.AppModule.provideCoinRepository
import com.kg.cryptocurrencytracker.dependency_injection.AppModule.providePaprikaApi
import com.kg.cryptocurrencytracker.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// builder and singleton design pattern
// explain builder and singleton design patterns a little bit
/**
 * This module is used to provide the dependencies for the application.
 * It is installed in the SingletonComponent.
 * It provides the CoinPaprikaApi and CoinRepository instances.
 * @constructor It creates an instance of the AppModule class.
 * @property providePaprikaApi It is a function that provides the CoinPaprikaApi instance.
 * @property provideCoinRepository It is a function that provides the CoinRepository instance.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi() : CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinPaprikaApi) : CoinRepository
    {
        return CoinRepositoryImpl(api)
    }
}