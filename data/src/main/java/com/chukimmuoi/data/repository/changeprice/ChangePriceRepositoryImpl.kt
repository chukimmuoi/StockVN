package com.chukimmuoi.data.repository.changeprice

import com.chukimmuoi.data.model.ChangePrice
import com.chukimmuoi.data.repository.changeprice.datasource.ChangePriceCacheDataSource
import com.chukimmuoi.data.repository.changeprice.datasource.ChangePriceLocalDataSource
import com.chukimmuoi.data.repository.changeprice.datasource.ChangePriceRemoteDataSource
import com.chukimmuoi.domain.repository.ChangePriceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 04/10/2022.
 */
class ChangePriceRepositoryImpl(
    private val cache: ChangePriceCacheDataSource,
    private val local: ChangePriceLocalDataSource,
    private val remote: ChangePriceRemoteDataSource
): ChangePriceRepository {

    companion object {
        const val VNINDEX_VALUE = "VNINDEX"
        const val HNX_VALUE = "HNX"
        const val UPCOM_VALUE = "UPCOM"
        const val VN30_VALUE = "VN30"
        const val VN30F1M_VALUE = "VN30F1M"

        const val TIME_VALUE = "1D"
    }

    override suspend fun <T> getChangePrice(): Flow<T> {
        return getChangePriceOnline()
            .flatMapConcat {
                if (it.isEmpty()) {
                    getChangePriceOnline()
                } else {
                    flowOf(it)
                }
            }.flowOn(Dispatchers.IO) as Flow<T>
    }

    private fun getChangePriceOnline(): Flow<List<ChangePrice>> {

        return flow {
            emit(
                remote.getChangePrices(
                    VNINDEX_VALUE, HNX_VALUE, UPCOM_VALUE, VN30_VALUE, VN30F1M_VALUE,
                    time = TIME_VALUE
                )
            )
        }.map {
            it.body()
        }.map {
            val changePrices = it?.data ?: listOf()
            if (changePrices.isNotEmpty()) {
                local.insertChangePrices(changePrices)
            }
            changePrices
        }
    }

    private fun getChangePriceOffline(): Flow<List<ChangePrice>> {

        return local.getChangePrices()
    }
}