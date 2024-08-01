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