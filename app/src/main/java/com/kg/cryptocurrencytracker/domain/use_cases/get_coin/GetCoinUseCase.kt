package com.kg.cryptocurrencytracker.domain.use_cases.get_coin

import com.kg.cryptocurrencytracker.common.Resource
import com.kg.cryptocurrencytracker.domain.model.CoinDetail
import com.kg.cryptocurrencytracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
class GetCoinUseCase @Inject constructor(
    private val repository : CoinRepository
){
    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> =
        flow {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId)
            emit(coin)
    }
}