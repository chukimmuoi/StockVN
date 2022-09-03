package com.chukimmuoi.data.repository.stock.datasourceimpl

import com.chukimmuoi.data.db.StockDao
import com.chukimmuoi.data.model.mapToData
import com.chukimmuoi.data.model.mapToDomain
import com.chukimmuoi.data.repository.stock.datasource.StockLocalDataSource
import com.chukimmuoi.domain.model.Stock
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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

    override fun getStock(): Flow<List<Stock>> {
        return stockDao.getAll().map { it.map { it.mapToDomain() } }
    }

    override suspend fun saveStock(stocks: List<Stock>): List<Long> {
        return stockDao.inserts(stocks.map { it.mapToData() })
    }

    override suspend fun clear(): Int {
        return stockDao.deleteAll()
    }
}