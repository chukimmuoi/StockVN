package com.chukimmuoi.data.repository.stock.datasource

import androidx.paging.PagingData
import com.chukimmuoi.data.model.Stock
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
interface StockLocalDataSource {

    fun getStock(): Flow<PagingData<Stock>>

    fun isExists(): Flow<Boolean>

    suspend fun saveStock(stocks: List<Stock>): List<Long>

    suspend fun clear(): Int
}