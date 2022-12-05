package com.chukimmuoi.data.repository.stock.datasourceimpl

import com.chukimmuoi.data.model.StockEntity
import com.chukimmuoi.data.repository.stock.datasource.StockCacheDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
class StockCacheDataSourceImpl: StockCacheDataSource {

    private var stockEntities = arrayListOf<StockEntity>()

    override fun getStock(): Flow<List<StockEntity>> = flowOf(stockEntities)

    override suspend fun saveStock(stockEntities: List<StockEntity>) {
        this.stockEntities.addAll(stockEntities)
    }

    override suspend fun clear() {
        this.stockEntities.clear()
    }
}