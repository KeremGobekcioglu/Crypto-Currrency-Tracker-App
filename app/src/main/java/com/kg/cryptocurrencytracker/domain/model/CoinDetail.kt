package com.kg.cryptocurrencytracker.domain.model

import com.kg.cryptocurrencytracker.data.remote.dto.TeamMember

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
