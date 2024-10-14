package com.kg.cryptocurrencytracker.domain.model

/**
 * This data class is used to define the Ticker model.
 * It has 25 properties: id, name, symbol, rank, totalSupply, maxSupply, betaValue, firstDataAt, lastUpdated, volume24h, volume24hChange24h, marketCap, marketCapChange24h, percentChange15m, percentChange30m, percentChange1h, percentChange6h, percentChange12h, percentChange24h, percentChange7d, percentChange30d, percentChange1y, athPrice, athDate, percentFromPriceAth, and price.
 * @property id It is a string that represents the unique identifier of the ticker.
 * @property name It is a string that represents the name of the ticker.
 * @property symbol It is a string that represents the symbol of the ticker.
 * @property rank It is an integer that represents the rank of the ticker.
 * @property totalSupply It is a long that represents the total supply of the ticker.
 * @property maxSupply It is a long that represents the maximum supply of the ticker.
 * @property betaValue It is a double that represents the beta value of the ticker.
 * @property firstDataAt It is a string that represents the date when the first data was recorded.
 * @property lastUpdated It is a string that represents the date when the data was last updated.
 * @property volume24h It is a double that represents the volume of the ticker in the last 24 hours.
 * @property volume24hChange24h It is a double that represents the change in volume in the last 24 hours.
 * @property marketCap It is a double that represents the market capitalization of the ticker.
 * @property marketCapChange24h It is a double that represents the change in market capitalization in the last 24 hours.
 * @property percentChange15m It is a double that represents the percentage change in the price in the last 15 minutes.
 * @property percentChange30m It is a double that represents the percentage change in the price in the last 30 minutes.
 * @property percentChange1h It is a double that represents the percentage change in the price in the last 1 hour.
 * @property percentChange6h It is a double that represents the percentage change in the price in the last 6 hours.
 * @property percentChange12h It is a double that represents the percentage change in the price in the last 12 hours.
 * @property percentChange24h It is a double that represents the percentage change in the price in the last 24 hours.
 * @property percentChange7d It is a double that represents the percentage change in the price in the last 7 days.
 * @property percentChange30d It is a double that represents the percentage change in the price in the last 30 days.
 * @property percentChange1y It is a double that represents the percentage change in the price in the last 1 year.
 * @property athPrice It is a double that represents the all-time high price of the ticker.
 * @property athDate It is a string that represents the date when the all-time high price was recorded.
 * @property percentFromPriceAth It is a double that represents the percentage change from the all-time high price.
 * @property price It is a double that represents the price of the ticker.
 */
data class Ticker(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val totalSupply: Long,
    val maxSupply: Long?,
    val betaValue: Double,
    val firstDataAt: String,
    val lastUpdated: String,
    val volume24h: Double,
    val volume24hChange24h: Double,
    val marketCap: Double,
    val marketCapChange24h: Double,
    val percentChange15m: Double,
    val percentChange30m: Double,
    val percentChange1h: Double,
    val percentChange6h: Double,
    val percentChange12h: Double,
    val percentChange24h: Double,
    val percentChange7d: Double,
    val percentChange30d: Double,
    val percentChange1y: Double,
    val athPrice: Double,
    val athDate: String,
    val percentFromPriceAth: Double,
    val price : Double
)
