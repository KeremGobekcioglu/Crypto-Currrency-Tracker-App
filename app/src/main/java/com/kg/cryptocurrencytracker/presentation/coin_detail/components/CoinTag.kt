package com.kg.cryptocurrencytracker.presentation.coin_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * This composable function is used to display a coin tag.
 * It takes a string as a parameter.
 * @param tag It is a string that represents the tag of the coin.
 */
@Composable
fun CoinTag(
    tag: String
)
{
    Box(
        modifier = Modifier.border(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(100.dp)
        )
            .padding(10.dp)

    ) {
        Text(
            text = tag,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}