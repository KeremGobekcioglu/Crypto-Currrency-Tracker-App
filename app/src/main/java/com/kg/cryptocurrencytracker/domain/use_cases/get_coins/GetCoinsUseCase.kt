package com.kg.cryptocurrencytracker.domain.use_cases.get_coins

import com.kg.cryptocurrencytracker.domain.repository.CoinRepository
import javax.inject.Inject
import com.kg.cryptocurrencytracker.domain.model.Coin
import com.kg.cryptocurrencytracker.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCoinsUseCase @Inject constructor(
    private val repository : CoinRepository
){
    operator fun invoke() : Flow<Resource<List<Coin>>> =
        flow {
                emit(Resource.Loading())
                val coins = repository.getCoins()
                emit(coins)
        }
}