package com.chukimmuoi.data.repository.stockprice.datasource

import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.model.StockPriceEntity
import com.chukimmuoi.data.model.VNDirectResponse
import com.chukimmuoi.data.paging.StockRemoteMediator
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
interface StockPriceRemoteDataSource {

    suspend fun getStockPrices(
        code: String,
        fromDate: String,
        toDate: String,
        size: Long
    ): Flow<Response<VNDirectResponse<StockPriceEntity>>>

    suspend fun getStockPricesInOneDay(
        date: String,
    ): Flow<Response<VNDirectResponse<StockPriceEntity>>>

    suspend fun getStockPricesInCurrentDay(): Flow<Response<VNDirectResponse<StockPriceEntity>>>

    suspend fun getAllStockPrices(code: String): Flow<Response<VNDirectResponse<StockPriceEntity>>>

    fun getAllStockPricesFollowPage(
        code: String,
        stockDatabase: StockDatabase
    ): StockRemoteMediator
}