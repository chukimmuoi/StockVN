package com.chukimmuoi.data.repository.stock.datasource

import com.chukimmuoi.data.model.StockEntity
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
interface StockCacheDataSource {

    fun getStock(): Flow<List<StockEntity>>

    suspend fun saveStock(stockEntities: List<StockEntity>)

    suspend fun clear()
}