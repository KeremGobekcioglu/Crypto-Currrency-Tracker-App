package com.kg.cryptocurrencytracker.presentation.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.kg.cryptocurrencytracker.common.formatPrice
import com.kg.cryptocurrencytracker.presentation.coin_detail.components.CoinStats
import com.kg.cryptocurrencytracker.presentation.coin_detail.components.CoinTag
import com.kg.cryptocurrencytracker.presentation.coin_detail.components.TeamListItem

/**
 * This composable function is used to display the CoinDetail screen.
 * It takes a CoinDetailViewModel as a parameter.
 * @param viewModel It is an instance of CoinDetailViewModel that represents the view model of the screen.
 * @constructor It creates a composable function that displays the CoinDetail screen.
 */
@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
)
{
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coin ->
                LazyColumn(modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        )
                        {
                            Text(
                                text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.weight(8f)
                            )
                            Text(
                                text = if (coin.isActive) "active" else "inactive",
                                color = if (coin.isActive) Color.Green else Color.Red,
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .align(CenterVertically).weight(2f)
                            )
                        }

                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "            ${formatPrice(coin.price)} USD",
                            style = MaterialTheme.typography.headlineMedium,
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = coin.description,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Tags",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        // It ensures that if tags does not fit in the row,
                        // it will wrap to the next row
                        FlowRow(
                            mainAxisSpacing = 10.dp,
                            crossAxisSpacing = 10.dp,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            coin.tags.forEach { tag ->
                                CoinTag(tag = tag)
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        // Coin stats
                        CoinStats(
                            price = coin.price,
                            totalSupply = coin.totalSupply,
                            maxSupply = coin.maxSupply,
                            firstDataAt = coin.firstDataAt,
                            lastUpdated = coin.lastUpdated,
                            volume24h = coin.volume24h,
                            marketCap = coin.marketCap,
                            marketCapChange24h = coin.marketCapChange24h,
                            percentChange1h = coin.percentChange1h,
                            percentChange24h = coin.percentChange24h,
                            percentChange7d = coin.percentChange7d,
                            percentChange30d = coin.percentChange30d,
                            percentChange1y = coin.percentChange1y,
                            athPrice = coin.athPrice,
                            athDate = coin.athDate,
                            percentFromPriceAth = coin.percentFromPriceAth
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        if(coin.team.isNotEmpty()) {
                            Text(
                            text = "Team members",
                            style = MaterialTheme.typography.headlineMedium
                        )
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                    items(coin.team) { teamMember ->
                        TeamListItem(teamMember = teamMember,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                        HorizontalDivider()
                    }

            }
        }
        if(state.error.isNotBlank())
        {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center),
                textAlign = TextAlign.Center
            )
        }
        if(state.isLoading)
        {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}