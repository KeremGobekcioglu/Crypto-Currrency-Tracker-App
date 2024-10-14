package com.kg.cryptocurrencytracker.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kg.cryptocurrencytracker.common.formatPrice
import com.kg.cryptocurrencytracker.domain.model.Coin


/**
 * This composable function is used to display a single item in the list of coins.
 * It takes a Coin and a lambda function as parameters.
 * @param coin It is an instance of Coin that represents the coin data.
 * @param onItemClick It is a lambda function that takes a Coin as a parameter and returns Unit.
 */
@Composable
fun CoinListItem(
    coin: Coin,
    // Lambda function that takes a Coin as a parameter and returns Unit
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank}. ${coin.name}   (${coin.symbol})",
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = formatPrice(coin.price),
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (coin.isActive) "active" else "inactive", // Sets the text content
            color = if (coin.isActive) Color.Green else Color.Red, // Sets the text color
            fontStyle = MaterialTheme.typography.bodyMedium.fontStyle, // Sets the font style
            style = MaterialTheme.typography.bodyMedium, // Sets the text style
            textAlign = TextAlign.End, // Aligns the text to the end
            modifier = Modifier.align(CenterVertically) // Modifies the layout to align the text vertically centered
        )

    }
}