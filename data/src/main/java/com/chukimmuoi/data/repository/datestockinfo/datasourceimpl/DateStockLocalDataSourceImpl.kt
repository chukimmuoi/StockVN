package com.chukimmuoi.data.repository.datestockinfo.datasourceimpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.chukimmuoi.data.db.DateStockInfoDao
import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.model.DateStockInfo
import com.chukimmuoi.data.paging.StockRemoteMediator
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockLocalDataSource
import com.chukimmuoi.data.util.Constant
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
class DateStockLocalDataSourceImpl(
    val stockDatabase: StockDatabase
): DateStockLocalDataSource {

    private val dateStockInfoDao: DateStockInfoDao by lazy {
        stockDatabase.getDateStockInfoDao()
    }

    override suspend fun save(dateStockInfo: DateStockInfo): Long {
        return dateStockInfoDao.insert(dateStockInfo)
    }

    override suspend fun save(dateStockInfo: List<DateStockInfo>): List<Long> {
        return dateStockInfoDao.inserts(dateStockInfo)
    }

    override suspend fun isExists(code: String): Boolean {
        return dateStockInfoDao.isExists(code)
    }

    override suspend fun clear(code: String): Int {
        return dateStockInfoDao.delete(code)
    }

    override suspend fun clear(): Int {
        return dateStockInfoDao.deleteAll()
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllDataWithPage(
        code: String,
        stockRemoteMediator: StockRemoteMediator
    ): Flow<PagingData<DateStockInfo>> {
        val pagingSourceFactory = { dateStockInfoDao.selectAllDataWithPage(code) }

        return Pager(
            config = PagingConfig(pageSize = Constant.PAGE_SIZE),
            remoteMediator = stockRemoteMediator,
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}