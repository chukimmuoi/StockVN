package com.chukimmuoi.data.repository.datestockinfo

import com.chukimmuoi.data.model.DateStockInfo
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockCacheDataSource
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockLocalDataSource
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockRemoteDataSource
import com.chukimmuoi.domain.repository.DateStockInfoRepository
import kotlinx.coroutines.flow.*

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
class DateStockInfoRepositoryImpl(
    private val cache: DateStockCacheDataSource,
    private val local: DateStockLocalDataSource,
    private val remote: DateStockRemoteDataSource
): DateStockInfoRepository {

    override suspend fun <T> insert(dateStockInfo: T): Long {
        return local.save(dateStockInfo as DateStockInfo)
    }

    override suspend fun <T> inserts(dateStockInfo: List<T>): List<Long> {
        return local.save(dateStockInfo as List<DateStockInfo>)
    }

    override suspend fun <T> updateAllDataFromServer(code: String): Flow<T> {

        return flow { emit(remote.getAllDateStock(code)) }
            .map { it.body() }
            .map { it?.data }
            .map {
                if (local.isExists(code)) local.clear(code)

                inserts(it as List<T>)
                it
            } as Flow<T>
    }

    override suspend fun <T> getQuery(): Flow<T> {
        TODO("Not yet implemented")
    }

    override suspend fun clear(code: String): Int {
        return local.clear(code)
    }

    override suspend fun clear(): Int {
        return local.clear()
    }
}