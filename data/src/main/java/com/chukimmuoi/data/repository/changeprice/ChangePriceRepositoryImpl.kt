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
                    ChangePrice.VNINDEX_VALUE,
                    ChangePrice.HNX_VALUE,
                    ChangePrice.UPCOM_VALUE,
                    ChangePrice.VN30_VALUE,
                    ChangePrice.VN30F1M_VALUE,
                    ChangePrice.HNX30_VALUE,
                    time = ChangePrice.TIME_VALUE
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