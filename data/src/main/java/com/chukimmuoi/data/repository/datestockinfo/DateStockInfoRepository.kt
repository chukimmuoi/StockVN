package com.chukimmuoi.data.repository.datestockinfo

import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockCacheDataSource
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockLocalDataSource
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockRemoteDataSource
import com.chukimmuoi.domain.repository.DateStockInfoRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
class DateStockInfoRepository(
    private val cache: DateStockCacheDataSource,
    private val local: DateStockLocalDataSource,
    private val remote: DateStockRemoteDataSource
): DateStockInfoRepository {

    override suspend fun <T> insert(dateStockInfo: T): Long {
        TODO("Not yet implemented")
    }

    override suspend fun <T> inserts(dateStockInfo: List<T>): List<Long> {
        TODO("Not yet implemented")
    }

    override fun <T> getAll(): Flow<T> {
        TODO("Not yet implemented")
    }

    override fun <T> getQuery(): Flow<T> {
        TODO("Not yet implemented")
    }

    override suspend fun clear(): Boolean {
        TODO("Not yet implemented")
    }
}