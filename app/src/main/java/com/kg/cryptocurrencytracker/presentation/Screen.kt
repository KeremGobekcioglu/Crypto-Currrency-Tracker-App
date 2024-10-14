package com.kg.cryptocurrencytracker.presentation

/**
 * This sealed class is used to define the screens.
 * It has two objects: CoinListScreen and CoinDetailScreen.
 * @property route It is a string that represents the route of the screen.
 * @constructor It takes a string as a parameter.
 */
sealed class Screen(
    val route: String
)
{
    data object CoinListScreen : Screen("coin_list_screen")
    data object CoinDetailScreen : Screen("coin_detail_screen")
}