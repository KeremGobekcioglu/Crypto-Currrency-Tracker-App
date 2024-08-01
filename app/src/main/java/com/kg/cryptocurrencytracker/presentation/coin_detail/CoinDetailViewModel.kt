package com.kg.cryptocurrencytracker.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kg.cryptocurrencytracker.common.Constants
import com.kg.cryptocurrencytracker.common.Resource
import com.kg.cryptocurrencytracker.domain.use_cases.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(
){
    private val _state = mutableStateOf(CoinDetailState())
    val state : State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
        /*
        val coinId = savedStateHandle.get<String>(Constants.PARAM_COIN_ID)
        if (coinId != null) {
            getCoin(coinId)
}
         */
    }

    private fun getCoin(coinId : String)
    {
        getCoinDetailUseCase(coinId).onEach {
            result ->
            when(result)
            {
                is Resource.Loading ->
                {
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Error ->
                {
                    _state.value = CoinDetailState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Success ->
                {
                    _state.value = CoinDetailState(coin = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}