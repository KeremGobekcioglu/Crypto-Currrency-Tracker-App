package com.kg.cryptocurrencytracker.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kg.cryptocurrencytracker.common.Resource
import com.kg.cryptocurrencytracker.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * This view model class is used to handle the business logic of the CoinList screen.
 * It takes a GetCoinsUseCase as a parameter.
 * @param getCoinsUseCase It is an instance of GetCoinsUseCase that represents the use case to get the list of coins.
 * @constructor It takes a GetCoinsUseCase as a parameter.
 * @property state It is a State of CoinListState that represents the state of the screen.
 */
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state : State<CoinListState> = _state

    init {
        getCoins()
    }
    fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when(result)
            {
                is Resource.Loading -> {
                    // Update only the loading state, preserving the rest of the state
                    _state.value = _state.value.copy(isLoading = true)
                }
                is Resource.Error -> {
                    // Update the error state, preserving the coins and other fields
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Success -> {
                    // Update the coins list, reset loading, and clear the error
                    _state.value = _state.value.copy(
                        isLoading = false,
                        coins = result.data ?: emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}