package com.kg.cryptocurrencytracker.presentation.coin_detail

import com.kg.cryptocurrencytracker.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
