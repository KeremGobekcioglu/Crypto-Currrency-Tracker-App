package com.kg.cryptocurrencytracker.presentation.coin_detail

import com.kg.cryptocurrencytracker.domain.model.CoinDetail

/**
 * This data class is used to define the state of the CoinDetail screen.
 * It has three properties: isLoading, coin, and error.
 * @property isLoading It is a boolean that represents the loading state of the screen.
 * @property coin It is an instance of CoinDetail that represents the coin detail data.
 * @property error It is a string that represents the error message.
 */
data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
