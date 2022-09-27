package com.chukimmuoi.data.repository.stock.datasourceimpl

import androidx.paging.*
import com.chukimmuoi.data.db.StockDao
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.data.repository.stock.datasource.StockLocalDataSource
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
class StockLocalDataSourceImpl(
    private val stockDao: StockDao
): StockLocalDataSource {

    override fun getStock(): Flow<PagingData<Stock>> {
        val pagingSourceFactory = stockDao.getAll()

        return Pager(PagingConfig(pageSize = Constant.PAGE_SIZE)) { pagingSourceFactory }.flow
    }

    override suspend fun saveStock(stocks: List<Stock>): List<Long> {
        return stockDao.inserts(stocks)
    }

    override fun isExists(): Flow<Boolean> {
        return stockDao.isExists()
    }

    override suspend fun clear(): Int {
        return stockDao.deleteAll()
    }
}