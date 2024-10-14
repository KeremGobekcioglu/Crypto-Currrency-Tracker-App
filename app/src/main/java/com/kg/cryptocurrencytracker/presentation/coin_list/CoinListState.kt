package com.kg.cryptocurrencytracker.presentation.coin_list

import com.kg.cryptocurrencytracker.domain.model.Coin

/**
 * This data class is used to define the state of the CoinList screen.
 * It has three properties: isLoading, coins, and error.
 * @property isLoading It is a boolean that represents the loading state of the screen.
 * @property coins It is a list of Coin that represents the list of coins.
 * @property error It is a string that represents the error message.
 */
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = "",
)
