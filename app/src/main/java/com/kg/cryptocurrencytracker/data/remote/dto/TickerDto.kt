package com.kg.cryptocurrencytracker.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.kg.cryptocurrencytracker.domain.model.Ticker

/**
 * It is a data transfer object class that represents the ticker.
 */
data class TickerDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("total_supply")
    val totalSupply: Long,
    @SerializedName("max_supply")
    val maxSupply: Long?,
    @SerializedName("beta_value")
    val betaValue: Double,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("quotes")
    val quotes: Map<String, Quote>
)
/**
 * It is a data class that represents the quote.
 */
data class Quote(
    @SerializedName("price")
    val price: Double,
    @SerializedName("volume_24h")
    val volume24h: Double,
    @SerializedName("volume_24h_change_24h")
    val volume24hChange24h: Double,
    @SerializedName("market_cap")
    val marketCap: Double,
    @SerializedName("market_cap_change_24h")
    val marketCapChange24h: Double,
    @SerializedName("percent_change_15m")
    val percentChange15m: Double,
    @SerializedName("percent_change_30m")
    val percentChange30m: Double,
    @SerializedName("percent_change_1h")
    val percentChange1h: Double,
    @SerializedName("percent_change_6h")
    val percentChange6h: Double,
    @SerializedName("percent_change_12h")
    val percentChange12h: Double,
    @SerializedName("percent_change_24h")
    val percentChange24h: Double,
    @SerializedName("percent_change_7d")
    val percentChange7d: Double,
    @SerializedName("percent_change_30d")
    val percentChange30d: Double,
    @SerializedName("percent_change_1y")
    val percentChange1y: Double,
    @SerializedName("ath_price")
    val athPrice: Double,
    @SerializedName("ath_date")
    val athDate: String,
    @SerializedName("percent_from_price_ath")
    val percentFromPriceAth: Double
)

/**
 * It is an extension function that converts the TickerDto to Ticker.
 */
fun TickerDto.toTicker(): Ticker {
    val usdQuote = quotes["USD"] ?: error("USD quote not found")
    return Ticker(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        totalSupply = totalSupply,
        maxSupply = maxSupply,
        betaValue = betaValue,
        firstDataAt = firstDataAt,
        lastUpdated = lastUpdated,
        volume24h = usdQuote.volume24h,
        volume24hChange24h = usdQuote.volume24hChange24h,
        marketCap = usdQuote.marketCap,
        marketCapChange24h = usdQuote.marketCapChange24h,
        percentChange15m = usdQuote.percentChange15m,
        percentChange30m = usdQuote.percentChange30m,
        percentChange1h = usdQuote.percentChange1h,
        percentChange6h = usdQuote.percentChange6h,
        percentChange12h = usdQuote.percentChange12h,
        percentChange24h = usdQuote.percentChange24h,
        percentChange7d = usdQuote.percentChange7d,
        percentChange30d = usdQuote.percentChange30d,
        percentChange1y = usdQuote.percentChange1y,
        athPrice = usdQuote.athPrice,
        athDate = usdQuote.athDate,
        percentFromPriceAth = usdQuote.percentFromPriceAth,
        price = usdQuote.price
    )
}