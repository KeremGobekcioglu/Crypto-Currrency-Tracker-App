package com.kg.cryptocurrencytracker.domain.use_cases.get_coin

import com.kg.cryptocurrencytracker.common.Resource
import com.kg.cryptocurrencytracker.domain.model.CoinDetail
import com.kg.cryptocurrencytracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * This use case class is used to get the details of a coin by its id.
 * It has a CoinRepository instance as a dependency.
 * @property repository It is an instance of the CoinRepository interface.
 * @constructor It takes an instance of the CoinRepository interface as a parameter.
 */
class GetCoinUseCase @Inject constructor(
    private val repository : CoinRepository
){
    /**
     * This method is used to get the details of a coin by its id.
     * It returns a Resource object with the details of the coin.
     * Basically it emits the loading state, then fetches the coin details from the repository,
     * and then emits the success state with the coin details.
     * If there is an error, it emits the error state with the error message.
     * @param coinId It is the id of the coin.
     * @return Flow<Resource<CoinDetail>> It returns a flow of Resource object with the details of the coin.
     */
    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> =
        flow {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId)
            emit(coin)
    }
}