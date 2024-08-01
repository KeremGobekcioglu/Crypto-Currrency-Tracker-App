package com.kg.cryptocurrencytracker.presentation.coin_list

import com.kg.cryptocurrencytracker.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
