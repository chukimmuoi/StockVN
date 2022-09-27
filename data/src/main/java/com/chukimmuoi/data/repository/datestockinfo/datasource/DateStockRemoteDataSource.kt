package com.chukimmuoi.data.repository.datestockinfo.datasource

import com.chukimmuoi.data.db.StockDatabase
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
interface DateStockRemoteDataSource {

    suspend fun getDateStock(
        code: String,
        fromDate: String,
        toDate: String,
        size: Long
    ): Response<VNDirectResponse>

    suspend fun getAllDateStock(code: String): Response<VNDirectResponse>

    fun getAllDateStockFollowPage(
        code: String,
        stockDatabase: StockDatabase
    ): StockRemoteMediator
}