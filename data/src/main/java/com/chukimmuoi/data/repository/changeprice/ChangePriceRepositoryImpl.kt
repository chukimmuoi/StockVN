package com.chukimmuoi.data.repository.changeprice

import com.chukimmuoi.data.model.ChangePriceEntity
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
                    getChangePriceOffline()
                } else {
                    flowOf(it)
                }
            }
            .map {
                it.sortedBy { it.code }
            }
            .flowOn(Dispatchers.IO) as Flow<T>
    }

    private fun getChangePriceOnline(): Flow<List<ChangePriceEntity>> {

        return flow {
            emit(
                remote.getChangePrices(
                    ChangePriceEntity.VNINDEX_VALUE,
                    ChangePriceEntity.HNX_VALUE,
                    ChangePriceEntity.UPCOM_VALUE,
                    ChangePriceEntity.VN30_VALUE,
                    ChangePriceEntity.VN30F1M_VALUE,
                    ChangePriceEntity.HNX30_VALUE,
                    time = ChangePriceEntity.TIME_VALUE
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

    private fun getChangePriceOffline(): Flow<List<ChangePriceEntity>> {

        return local.getChangePrices()
    }
}