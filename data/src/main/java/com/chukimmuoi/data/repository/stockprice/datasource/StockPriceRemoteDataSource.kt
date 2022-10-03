package com.chukimmuoi.data.repository.stockprice.datasource

import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.model.StockPrice
import com.chukimmuoi.data.model.VNDirectResponse
import com.chukimmuoi.data.paging.StockRemoteMediator
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
    ): Response<VNDirectResponse<StockPrice>>

    suspend fun getAllStockPrices(code: String): Response<VNDirectResponse<StockPrice>>

    fun getAllStockPricesFollowPage(
        code: String,
        stockDatabase: StockDatabase
    ): StockRemoteMediator
}