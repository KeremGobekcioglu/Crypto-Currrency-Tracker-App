package com.kg.cryptocurrencytracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kg.cryptocurrencytracker.presentation.coin_detail.CoinDetailScreen
import com.kg.cryptocurrencytracker.presentation.coin_list.CoinListScreen
import com.kg.cryptocurrencytracker.presentation.ui.CryptoCurrencyTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * This class is used to display the main activity of the application.
 * Navigation is set up in this class.
 *
 * Navigation is set up using Jetpack Compose's Navigation component:
 * 1. `rememberNavController`: A `NavController` is created using `rememberNavController()`. This controller will manage the navigation within the app.
 * 2. `NavHost`: The `NavHost` composable is used to define the navigation graph. It takes the `NavController` and the start destination as parameters.
 * 3. `composable`: Inside the `NavHost`, the `composable` function is used to define individual composable destinations. Each destination is associated with a route.
 * 4. Routes: The routes are defined in the `Screen` sealed class. There are two routes: `CoinListScreen` and `CoinDetailScreen`.
 * 5. Navigation: When navigating to a different screen, the `navController.navigate` function is used with the appropriate route.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyTrackerTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    )
                    {
                        composable(route = Screen.CoinListScreen.route)
                        {
                            CoinListScreen(navController = navController)
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}")
                        {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

