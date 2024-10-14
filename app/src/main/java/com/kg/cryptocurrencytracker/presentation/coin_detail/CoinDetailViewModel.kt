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

/**
 * This view model class is used to handle the business logic of the CoinDetail screen.
 * It takes a GetCoinUseCase and a SavedStateHandle as parameters.
 * @param getCoinDetailUseCase It is an instance of GetCoinUseCase that represents the use case to get the coin detail data.
 * @param savedStateHandle It is an instance of SavedStateHandle that represents the saved state handle of the screen.
 * @constructor It takes a GetCoinUseCase and a SavedStateHandle as parameters.
 * @property state It is a State of CoinDetailState that represents the state of the screen.
 */
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
    }

    private fun getCoin(coinId : String)
    {
        getCoinDetailUseCase(coinId).onEach {
            result ->
            when(result)
            {
                is Resource.Loading ->
                {
                    _state.value = _state.value.copy(isLoading = true)
                }
                is Resource.Error ->
                {
                    _state.value = _state.value.copy(error = result.message ?: "An unexpected error" , isLoading = false)//CoinDetailState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Success ->
                {
                    _state.value = _state.value.copy(coin = result.data , isLoading = false)  //CoinDetailState(coin = result.data , error = "getcoin success")
                }
            }
        }.launchIn(viewModelScope)
    }
}