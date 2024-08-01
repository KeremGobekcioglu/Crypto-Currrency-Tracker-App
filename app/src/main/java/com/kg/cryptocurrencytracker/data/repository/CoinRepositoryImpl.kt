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

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): Resource<List<Coin>> {
        return try {
            // ticker da çekilicek ve ordaki price verisi coinlere aktarilacak
            val coinsDto = api.getCoins()
            val tickersDto = api.getTickers()
//            val coins = coinsDto.map { coinDto -> // Iterate over each coinDto in coinsDto
//                val price = tickersDto.find { it.id == coinDto.id } // Find the corresponding tickerDto in tickersDto where the id matches
//                    ?.quotes?.get("USD")?.price // Extract the price from the quotes map for the "USD" key
//                    ?: 0.0 // Default to 0.0 if the price is not found
//                coinDto.toCoin(price) // Convert coinDto to Coin using the toCoin function, passing the extracted price
//            }
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