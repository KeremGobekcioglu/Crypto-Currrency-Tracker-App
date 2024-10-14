package com.kg.cryptocurrencytracker.domain.model

/**
 * This data class is used to define the Coin model.
 * It has five properties: id, isActive, name, rank, and symbol.
 * @property id It is a string that represents the unique identifier of the coin.
 * @property isActive It is a boolean that represents the active state of the coin.
 * @property name It is a string that represents the name of the coin.
 * @property rank It is an integer that represents the rank of the coin.
 * @property symbol It is a string that represents the symbol of the coin.
 * @property price It is a double that represents the price of the coin.
 */
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val price : Double
)
