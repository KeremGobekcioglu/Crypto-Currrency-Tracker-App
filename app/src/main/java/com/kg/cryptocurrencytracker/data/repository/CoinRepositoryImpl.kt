package com.kg.cryptocurrencytracker.data.repository

import com.kg.cryptocurrencytracker.common.Resource
import com.kg.cryptocurrencytracker.data.remote.CoinPaprikaApi
import com.kg.cryptocurrencytracker.data.remote.dto.toCoin
import com.kg.cryptocurrencytracker.data.remote.dto.toCoinDetail
import com.kg.cryptocurrencytracker.data.remote.dto.toTicker
import com.kg.cryptocurrencytracker.domain.model.Coin
import com.kg.cryptocurrencytracker.domain.model.CoinDetail
import com.kg.cryptocurrencytracker.domain.model.Ticker
import com.kg.cryptocurrencytracker.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * This repository implementation class is used to fetch the data from the network.
 * It implements the CoinRepository interface.
 * It has three methods: getCoins, getCoinById, and getTickers.
 * @property api It is an instance of the CoinPaprikaApi interface.
 * @constructor It takes an instance of the CoinPaprikaApi interface as a parameter.
 */

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository {
    /**
     * This method is used to fetch the list of coins.
     * It returns a Resource object with a list of coins.
     * If the network call is successful, it returns a Resource.Success object with the list of coins.
     * If the network call fails, it returns a Resource.Error object with an error message.
     * @return Resource<List<Coin>> It returns a Resource object with a list of coins.
     */
    override suspend fun getCoins(): Resource<List<Coin>> {
        return try {
            // ticker da çekilicek ve ordaki price verisi coinlere aktarilacak
            val coinsDto = api.getCoins()
            val tickersDto = api.getTickers()
            val tickers = tickersDto.map { it.toTicker() }

            // Create a map of ticker prices for quick lookup
            val tickerPriceMap = tickers.associateBy({ it.id }, { it.price })

            // Map prices from ticker to coins
            val coins = coinsDto.map { coinDto ->
                val price = tickerPriceMap[coinDto.id] ?: 0.0
                coinDto.toCoin(price)
            }
            Resource.Success(coins)
        } catch (e: HttpException) {
            Resource.Error("An error occurred: ${e.localizedMessage}")
        } catch (e: IOException) {
            Resource.Error("Check your internet connection")
        }
    }

    /**
     * This method is used to fetch the details of a coin by its id.
     * It returns a Resource object with the details of the coin.
     * If the network call is successful, it returns a Resource.Success object with the details of the coin.
     * If the network call fails, it returns a Resource.Error object with an error message.
     * @param coinId It is the id of the coin.
     * @return Resource<CoinDetail> It returns a Resource object with the details of the coin.
     */
    override suspend fun getCoinById(coinId: String): Resource<CoinDetail> {
        return try
        {
            val coinDetailDto = api.getCoinById(coinId)
            val tickerDto = api.getTickerById(coinId)
            val ticker = tickerDto.toTicker()
            val coinDetail = coinDetailDto.toCoinDetail(ticker)
            Resource.Success(coinDetail)
        }
        catch (e: HttpException)
        {
            Resource.Error("An error occurred: ${e.localizedMessage}")
        }
        catch (e: IOException)
        {
            Resource.Error("Check your internet connection")
        }
    }

    /**
     * This method is used to fetch the list of tickers.
     * It returns a Resource object with a list of tickers.
     * If the network call is successful, it returns a Resource.Success object with the list of tickers.
     * If the network call fails, it returns a Resource.Error object with an error message.
     * @param coinId It is the id of the coin.
     * @return Resource<List<Ticker>> It returns a Resource object with a list of tickers.
     */
    override suspend fun getTickerById(coinId: String): Resource<Ticker> {
        return try
        {
            val tickerDto = api.getTickerById(coinId)
            val ticker = tickerDto.toTicker()
            Resource.Success(ticker)
        }
        catch (e: HttpException)
        {
            Resource.Error("An error occurred: ${e.localizedMessage}")
        }
        catch (e: IOException)
        {
            Resource.Error("Check your internet connection")
        }
    }

    /**
     * This method is used to fetch the list of tickers.
     * It returns a Resource object with a list of tickers.
     * If the network call is successful, it returns a Resource.Success object with the list of tickers.
     * If the network call fails, it returns a Resource.Error object with an error message.
     * @return Resource<List<Ticker>> It returns a Resource object with a list of tickers.
     */
    override suspend fun getTickers(): Resource<List<Ticker>> {
        return try
        {
            val tickersDto = api.getTickers()
            val tickers = tickersDto.map { it.toTicker() }
            Resource.Success(tickers)
        }
        catch (e: HttpException)
        {
            Resource.Error("An error occurred: ${e.localizedMessage}")
        }
        catch (e: IOException)
        {
            Resource.Error("Check your internet connection")
        }
    }
}