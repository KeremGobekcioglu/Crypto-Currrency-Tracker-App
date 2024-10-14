package com.kg.cryptocurrencytracker.presentation.coin_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kg.cryptocurrencytracker.common.formatPrice

/**
 * This composable function is used to display the statistics of a coin.
 * It takes various parameters such as price, total supply, max supply, etc.
 * @param price It is a double that represents the price of the coin.
 * @param totalSupply It is a long that represents the total supply of the coin.
 * @param maxSupply It is a long that represents the maximum supply of the coin.
 * @param firstDataAt It is a string that represents the date when the first data was recorded.
 * @param lastUpdated It is a string that represents the date when the data was last updated.
 * @param volume24h It is a double that represents the volume of the coin in the last 24 hours.
 * @param marketCap It is a double that represents the market capitalization of the coin.
 * @param marketCapChange24h It is a double that represents the change in market capitalization in the last 24 hours.
 * @param percentChange1h It is a double that represents the percentage change in the price in the last 1 hour.
 * @param percentChange24h It is a double that represents the percentage change in the price in the last 24 hours.
 * @param percentChange7d It is a double that represents the percentage change in the price in the last 7 days.
 * @param percentChange30d It is a double that represents the percentage change in the price in the last 30 days.
 * @param percentChange1y It is a double that represents the percentage change in the price in the last 1 year.
 * @param athPrice It is a double that represents the all-time high price of the coin.
 * @param athDate It is a string that represents the date when the all-time high price was recorded.
 * @param percentFromPriceAth It is a double that represents the percentage change from the all-time high price.
 */
@Composable
fun CoinStats(
    price : Double,
    totalSupply: Long,
    maxSupply: Long?,
    firstDataAt: String,
    lastUpdated: String,
    volume24h: Double,
    marketCap: Double,
    marketCapChange24h: Double,
    percentChange1h: Double,
    percentChange24h: Double,
    percentChange7d: Double,
    percentChange30d: Double,
    percentChange1y: Double,
    athPrice: Double,
    athDate: String,
    percentFromPriceAth: Double
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Coin Statistics",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        StatItem("PRICE", formatPrice(price))
        StatItem("Total Supply", totalSupply.toString())
        StatItem("Max Supply", maxSupply?.toString() ?: "N/A")
        StatItem("First Data At", firstDataAt)
        StatItem("Last Updated", lastUpdated)
        StatItem("Volume (24h)", volume24h.toString())
        StatItem("Market Cap", marketCap.toString())
        StatItem("Market Cap Change (24h)", marketCapChange24h.toString())
        StatItem("Percent Change (1h)", percentChange1h.toString())
        StatItem("Percent Change (24h)", percentChange24h.toString())
        StatItem("Percent Change (7d)", percentChange7d.toString())
        StatItem("Percent Change (30d)", percentChange30d.toString())
        StatItem("Percent Change (1y)", percentChange1y.toString())
        StatItem("ATH Price", athPrice.toString())
        StatItem("ATH Date", athDate)
        StatItem("Percent From ATH", percentFromPriceAth.toString())
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val color = when {
            (label.contains("Percent") || label.contains("Change")) && value.startsWith("-") -> Color.Red
            (label.contains("Percent") || label.contains("Change")) && !value.startsWith("-") -> Color.Green
            else -> MaterialTheme.colorScheme.onSurface
        }
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = if(label.contains("Percent") || label.contains("Change")) "% $value" else value,
            color = color,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End,
            modifier = Modifier.weight(1f)
        )
    }
    HorizontalDivider()
}