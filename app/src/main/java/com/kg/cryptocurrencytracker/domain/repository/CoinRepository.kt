package com.kg.cryptocurrencytracker.domain.repository
import com.kg.cryptocurrencytracker.common.Resource
import com.kg.cryptocurrencytracker.domain.model.Coin
import com.kg.cryptocurrencytracker.domain.model.CoinDetail
import com.kg.cryptocurrencytracker.domain.model.Ticker

interface CoinRepository {

    suspend fun getCoins() : Resource<List<Coin>>

    suspend fun getCoinById(coinId : String) : Resource<CoinDetail>

    suspend fun getTickerById(coinId: String) : Resource<Ticker>

    suspend fun getTickers() : Resource<List<Ticker>>
}