package com.chukimmuoi.data.repository.stockprice.datasourceimpl

import com.chukimmuoi.data.api.StockApi
import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.model.StockPrice
import com.chukimmuoi.data.model.VNDirectResponse
import com.chukimmuoi.data.paging.StockRemoteMediator
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceRemoteDataSource
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
class StockPriceRemoteDataSourceImpl(
    private val stockApi: StockApi
): StockPriceRemoteDataSource {

    private fun getCurrentDateString(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")

        return sdf.format(Date())
    }

    private fun getDateFromString(date: String): LocalDate {
        val sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        return LocalDate.parse(date, sdf)
    }

    override suspend fun getStockPrices(
        code: String,
        fromDate: String,
        toDate: String,
        size: Long
    ): Response<VNDirectResponse<StockPrice>> {
        val query = "code:$code~date:gte:$fromDate~date:lte:$toDate"

        return stockApi.getStockPrices(
            query = query,
            size = size
        )
    }

    override suspend fun getStockPricesInOneDay(
        date: String
    ): Response<VNDirectResponse<StockPrice>> {
        val query = "code:~date:gte:$date~date:lte:$date"

        return stockApi.getStockPricesInOneDay(
            query = query
        )
    }

    override suspend fun getStockPricesInCurrentDay(): Response<VNDirectResponse<StockPrice>> {
        val currentDateString = getCurrentDateString()

        return getStockPricesInOneDay(currentDateString)
    }

    override suspend fun getAllStockPrices(code: String): Response<VNDirectResponse<StockPrice>> {
        val startDateString = "2000-01-01"
        val currentDateString = getCurrentDateString()

        val startDate = getDateFromString(startDateString)
        val currentDate = getDateFromString(currentDateString)
        val daysBetween = ChronoUnit.DAYS.between(startDate, currentDate)

        return getStockPrices(code, startDateString, currentDateString, daysBetween)
    }

    override fun getAllStockPricesFollowPage(
        code: String,
        stockDatabase: StockDatabase
    ): StockRemoteMediator {
        val startDateString = "2000-01-01"
        val currentDateString = getCurrentDateString()

        val query = "code:$code~date:gte:$startDateString~date:lte:$currentDateString"

        return StockRemoteMediator(
            code,
            query,
            stockApi,
            stockDatabase
        )
    }
}