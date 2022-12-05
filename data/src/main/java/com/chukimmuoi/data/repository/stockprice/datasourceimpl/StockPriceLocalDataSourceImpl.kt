package com.chukimmuoi.data.repository.stockprice.datasourceimpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.chukimmuoi.data.db.StockPriceDao
import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.model.StockPriceEntity
import com.chukimmuoi.data.paging.StockRemoteMediator
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceLocalDataSource
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
class StockPriceLocalDataSourceImpl(
    val stockDatabase: StockDatabase
): StockPriceLocalDataSource {

    private val stockPriceDao: StockPriceDao by lazy {
        stockDatabase.getStockPriceDao()
    }

    override suspend fun save(stockPriceEntity: StockPriceEntity): Long {
        return stockPriceDao.insert(stockPriceEntity)
    }

    override suspend fun save(stockPriceEntity: List<StockPriceEntity>): List<Long> {
        return stockPriceDao.inserts(stockPriceEntity)
    }

    override suspend fun isExists(code: String): Boolean {
        return stockPriceDao.isExists(code)
    }

    override suspend fun clear(code: String): Int {
        return stockPriceDao.delete(code)
    }

    override suspend fun clear(): Int {
        return stockPriceDao.deleteAll()
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllDataWithPage(
        code: String,
        stockRemoteMediator: StockRemoteMediator
    ): Flow<PagingData<StockPriceEntity>> {
        val pagingSourceFactory = { stockPriceDao.selectAllDataWithPage(code) }

        return Pager(
            config = PagingConfig(pageSize = Constant.PAGE_SIZE),
            remoteMediator = stockRemoteMediator,
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}