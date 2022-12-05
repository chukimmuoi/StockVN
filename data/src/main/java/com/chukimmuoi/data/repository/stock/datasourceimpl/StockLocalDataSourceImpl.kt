package com.chukimmuoi.data.repository.stock.datasourceimpl

import androidx.paging.*
import com.chukimmuoi.data.db.StockDao
import com.chukimmuoi.data.model.StockEntity
import com.chukimmuoi.data.repository.stock.datasource.StockLocalDataSource
import com.chukimmuoi.data.util.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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

    override fun getStock(floor: String): Flow<PagingData<StockEntity>> {
        return Pager(PagingConfig(pageSize = Constant.PAGE_SIZE)) { stockDao.getAllOrFloor(floor) }.flow
    }

    override fun getBookmarkedStock(): Flow<PagingData<StockEntity>> {
        return Pager(PagingConfig(pageSize = Constant.PAGE_SIZE)) {
            stockDao.getAllBookmarked()
        }.flow
    }

    override fun getPurchasedStock(): Flow<PagingData<StockEntity>> {
        return Pager(PagingConfig(pageSize = Constant.PAGE_SIZE)) {
            stockDao.getAllPurchased()
        }.flow
    }

    override suspend fun updateStock(stockEntity: StockEntity): Flow<Long> {
        return flow {
            emit(stockDao.insertOrUpdate(stockEntity))
        }
    }

    override suspend fun saveStock(stockEntities: List<StockEntity>): List<Long> {
        return stockDao.inserts(stockEntities)
    }

    override fun isExists(): Flow<Boolean> {
        return stockDao.isExists()
    }

    override suspend fun clear(): Int {
        return stockDao.deleteAll()
    }
}