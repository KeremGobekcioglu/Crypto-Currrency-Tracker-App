package com.kg.cryptocurrencytracker.domain.use_cases.get_coins

import com.kg.cryptocurrencytracker.common.Resource
import com.kg.cryptocurrencytracker.domain.model.Coin
import com.kg.cryptocurrencytracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * This use case class is used to get the list of coins.
 * It has a CoinRepository instance as a dependency.
 * @property repository It is an instance of the CoinRepository interface.
 * @constructor It takes an instance of the CoinRepository interface as a parameter.
 */
class GetCoinsUseCase @Inject constructor(
    private val repository : CoinRepository
){
    /**
     * This method is used to get the list of coins.
     * It returns a Resource object with the list of coins.
     * Basically it emits the loading state, then fetches the list of coins from the repository,
     * and then emits the success state with the list of coins.
     * If there is an error, it emits the error state with the error message.
     * @return Flow<Resource<List<Coin>> It returns a flow of Resource object with the list of coins.
     */
    operator fun invoke() : Flow<Resource<List<Coin>>> =
        flow {
                emit(Resource.Loading())
                val coins = repository.getCoins()
                emit(coins)
        }
}