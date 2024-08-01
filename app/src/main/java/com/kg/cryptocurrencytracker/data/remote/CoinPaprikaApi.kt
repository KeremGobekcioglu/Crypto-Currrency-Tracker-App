package com.kg.cryptocurrencytracker.data.remote
import com.kg.cryptocurrencytracker.data.remote.dto.CoinDetailDto
import com.kg.cryptocurrencytracker.data.remote.dto.CoinDto
import com.kg.cryptocurrencytracker.data.remote.dto.TickerDto
import retrofit2.http.GET
import retrofit2.http.Path

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