package com.kg.cryptocurrencytracker.domain.repository
import com.kg.cryptocurrencytracker.common.Resource
import com.kg.cryptocurrencytracker.domain.model.Coin
import com.kg.cryptocurrencytracker.domain.model.CoinDetail
import com.kg.cryptocurrencytracker.domain.model.Ticker

/**
 * It is an interface that represents the repository for the coin.
 * It has four functions: getCoins, getCoinById, getTickerById, and getTickers.
 * @property getCoins It is a suspend function that returns a list of Coin.
 * @property getCoinById It is a suspend function that takes a coinId as a parameter and returns a CoinDetail.
 * @property getTickerById It is a suspend function that takes a coinId as a parameter and returns a Ticker.
 * @property getTickers It is a suspend function that returns a list of Ticker.
 */
interface CoinRepository {

    suspend fun getCoins() : Resource<List<Coin>>

    suspend fun getCoinById(coinId : String) : Resource<CoinDetail>

    suspend fun getTickerById(coinId: String) : Resource<Ticker>

    suspend fun getTickers() : Resource<List<Ticker>>
}