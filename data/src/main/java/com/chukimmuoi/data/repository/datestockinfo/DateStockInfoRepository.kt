package com.chukimmuoi.data.repository.datestockinfo

import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockCacheDataSource
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockLocalDataSource
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockRemoteDataSource
import com.chukimmuoi.domain.model.DateStockInfo
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

    override suspend fun insert(dateStockInfo: DateStockInfo): Long {
        TODO("Not yet implemented")
    }

    override suspend fun inserts(dateStockInfo: List<DateStockInfo>): List<Long> {
        TODO("Not yet implemented")
    }

    override fun getAll(): Flow<List<DateStockInfo>> {
        TODO("Not yet implemented")
    }

    override fun getQuery(): Flow<List<DateStockInfo>> {
        TODO("Not yet implemented")
    }

    override suspend fun clear(): Boolean {
        TODO("Not yet implemented")
    }
}