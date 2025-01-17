package com.chukimmuoi.data.repository.stockprice.datasource

import androidx.paging.PagingData
import com.chukimmuoi.data.model.StockPrice
import com.chukimmuoi.data.paging.StockRemoteMediator
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
interface StockPriceLocalDataSource {

    suspend fun save(stockPrice: StockPrice): Long

    suspend fun save(stockPrice: List<StockPrice>): List<Long>

    suspend fun isExists(code: String): Boolean

    suspend fun clear(code: String): Int

    suspend fun clear(): Int

    fun getAllDataWithPage(
        code: String,
        stockRemoteMediator: StockRemoteMediator
    ): Flow<PagingData<StockPrice>>
}