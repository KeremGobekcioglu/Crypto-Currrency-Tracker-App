package com.kg.cryptocurrencytracker.common

/**
 * This function formats the price to a more readable format
 * @param price It is a double that represents the price of the coin.
 * @return A string that represents the formatted price.
 */
fun formatPrice(price: Double): String {
    return if (price >= 1.0) {
        "%.2f".format(price)
    } else {
        // lets round a bit more for small numbers
        "%.6f".format(price)
    }
}