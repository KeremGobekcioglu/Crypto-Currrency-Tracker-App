package com.kg.cryptocurrencytracker.domain.model

import com.kg.cryptocurrencytracker.data.remote.dto.TeamMember

/**
 * This data class is used to define the CoinDetail model.
 * It has 24 properties: coinId, name, symbol, description, rank, isActive, tags, team, totalSupply, maxSupply, firstDataAt, lastUpdated, volume24h, marketCap, marketCapChange24h, percentChange1h, percentChange24h, percentChange7d, percentChange30d, percentChange1y, athPrice, athDate, percentFromPriceAth, and price.
 * @property coinId It is a string that represents the unique identifier of the coin.
 * @property name It is a string that represents the name of the coin.
 * @property symbol It is a string that represents the symbol of the coin.
 * @property description It is a string that represents the description of the coin.
 * @property rank It is an integer that represents the rank of the coin.
 * @property isActive It is a boolean that represents the active state of the coin.
 * @property tags It is a list of string that represents the tags of the coin.
 * @property team It is a list of TeamMember that represents the team members of the coin.
 * @property totalSupply It is a long that represents the total supply of the coin.
 * @property maxSupply It is a long that represents the maximum supply of the coin.
 * @property firstDataAt It is a string that represents the date when the first data was recorded.
 * @property lastUpdated It is a string that represents the date when the data was last updated.
 * @property volume24h It is a double that represents the volume of the coin in the last 24 hours.
 * @property marketCap It is a double that represents the market capitalization of the coin.
 * @property marketCapChange24h It is a double that represents the change in market capitalization in the last 24 hours.
 * @property percentChange1h It is a double that represents the percentage change in the price in the last 1 hour.
 * @property percentChange24h It is a double that represents the percentage change in the price in the last 24 hours.
 * @property percentChange7d It is a double that represents the percentage change in the price in the last 7 days.
 * @property percentChange30d It is a double that represents the percentage change in the price in the last 30 days.
 * @property percentChange1y It is a double that represents the percentage change in the price in the last 1 year.
 * @property athPrice It is a double that represents the all-time high price of the coin.
 * @property athDate It is a string that represents the date when the all-time high price was recorded.
 * @property percentFromPriceAth It is a double that represents the percentage change from the all-time high price.
 * @property price It is a double that represents the price of the coin.
 */
data class CoinDetail(
    val coinId : String,
    val name : String,
    val symbol : String,
    val description : String,
    val rank : Int,
    val isActive : Boolean,
    val tags : List<String>,
    val team : List<TeamMember>,
    val totalSupply: Long,
    val maxSupply: Long?,
    val firstDataAt: String,
    val lastUpdated: String,
    val volume24h: Double,
    val marketCap: Double,
    val marketCapChange24h: Double,
    val percentChange1h: Double,
    val percentChange24h: Double,
    val percentChange7d: Double,
    val percentChange30d: Double,
    val percentChange1y: Double,
    val athPrice: Double,
    val athDate: String,
    val percentFromPriceAth: Double,
    val price : Double,
)
