package com.kg.cryptocurrencytracker.common

fun formatPrice(price: Double): String {
    return if (price >= 1.0) {
        "%.2f".format(price)
    } else {
        // lets round a bit more for small numbers
        "%.6f".format(price)
    }
}