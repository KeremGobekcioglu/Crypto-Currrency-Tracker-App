package com.kg.cryptocurrencytracker.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.kg.cryptocurrencytracker.domain.model.Coin

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String,
)

fun CoinDto.toCoin(fiat : Double) : Coin
{
    return Coin(
        id = this.id,
        isActive = this.isActive,
        name = this.name,
        rank = this.rank,
        symbol = this.symbol,
        price = fiat
    )
}