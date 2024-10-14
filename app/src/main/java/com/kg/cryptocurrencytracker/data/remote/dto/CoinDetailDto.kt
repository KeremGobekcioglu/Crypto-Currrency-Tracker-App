package com.kg.cryptocurrencytracker.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.kg.cryptocurrencytracker.domain.model.CoinDetail
import com.kg.cryptocurrencytracker.domain.model.Ticker

/**
 * It is a data transfer object class that represents the coin detail.
 */
data class CoinDetailDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("team")
    val team: List<TeamMember>,
    @SerializedName("type")
    val type: String,
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper
)

/**
 * It is an extension function that converts the CoinDetailDto to CoinDetail.
 */
fun CoinDetailDto.toCoinDetail(ticker: Ticker): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        symbol = symbol,
        description = description,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team,
        price = ticker.price,
        totalSupply = ticker.totalSupply,
        maxSupply = ticker.maxSupply,
        firstDataAt = firstDataAt,
        lastUpdated = lastDataAt,
        volume24h = ticker.volume24h,
        marketCap = ticker.marketCap,
        marketCapChange24h = ticker.marketCapChange24h,
        percentChange1h = ticker.percentChange1h,
        percentChange24h = ticker.percentChange24h,
        percentChange7d = ticker.percentChange7d,
        percentChange30d = ticker.percentChange30d,
        percentChange1y = ticker.percentChange1y,
        athPrice = ticker.athPrice,
        athDate = ticker.athDate,
        percentFromPriceAth = ticker.percentFromPriceAth
    )
}