package com.kg.cryptocurrencytracker.data.remote
import com.kg.cryptocurrencytracker.data.remote.dto.CoinDetailDto
import com.kg.cryptocurrencytracker.data.remote.dto.CoinDto
import com.kg.cryptocurrencytracker.data.remote.dto.TickerDto
import retrofit2.http.GET
import retrofit2.http.Path

/*facade design pattern*/

/**
 * This interface is used to define the API endpoints.
 * Facade design pattern is used to provide a simple interface to a complex system.
 * It has four functions: getCoins, getCoinById, getTickerById, and getTickers.
 * @property getCoins It is a suspend function that returns a list of CoinDto.
 * @property getCoinById It is a suspend function that takes a coinId as a parameter and returns a CoinDetailDto.
 * @property getTickerById It is a suspend function that takes a coinId as a parameter and returns a TickerDto.
 * @property getTickers It is a suspend function that returns a list of TickerDto.
 */
interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId : String) : CoinDetailDto

    @GET("v1/tickers/{coinId}")
    suspend fun getTickerById(@Path("coinId") coinId: String): TickerDto

    @GET("v1/tickers")
    suspend fun getTickers() : List<TickerDto>
}