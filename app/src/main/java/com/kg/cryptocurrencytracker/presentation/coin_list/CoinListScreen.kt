package com.kg.cryptocurrencytracker.presentation.coin_list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.kg.cryptocurrencytracker.presentation.Screen
import com.kg.cryptocurrencytracker.presentation.coin_list.components.CoinListItem


/**
 * This composable function is used to display the CoinList screen.
 * It takes a NavController and a CoinListViewModel as parameters.
 * @param navController It is the navigation controller that is used to navigate between screens.
 * @param viewModel It is an instance of CoinListViewModel that represents the view model of the screen.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("DEPRECATION")
@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    var showSnackbar by remember { mutableStateOf(false) }

    LaunchedEffect(showSnackbar) {
        if (showSnackbar) {
            snackbarHostState.showSnackbar("List of coins refreshed")
            showSnackbar = false
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = state.isLoading),
            onRefresh = {
                viewModel.getCoins() // Trigger the API call to refresh data
                showSnackbar = true
            }
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.coins) { coin ->
                        CoinListItem(
                            coin = coin,
                            onItemClick = {
                                navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                            }
                        )
                    }
                }
                if (state.error.isNotBlank()) {
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
                if (state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}