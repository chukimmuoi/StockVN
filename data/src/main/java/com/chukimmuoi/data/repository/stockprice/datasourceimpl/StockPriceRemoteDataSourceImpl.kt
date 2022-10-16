package com.chukimmuoi.data.repository.stockprice.datasourceimpl

import com.chukimmuoi.data.api.StockApi
import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.model.StockPrice
import com.chukimmuoi.data.model.VNDirectResponse
import com.chukimmuoi.data.paging.StockRemoteMediator
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceRemoteDataSource
import com.chukimmuoi.data.util.currentDate
import com.chukimmuoi.data.util.toDate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
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

    override suspend fun getStockPrices(
        code: String,
        fromDate: String,
        toDate: String,
        size: Long
    ): Flow<Response<VNDirectResponse<StockPrice>>> {
        val query = "code:$code~date:gte:$fromDate~date:lte:$toDate"

        return flow {
            emit(
                stockApi.getStockPrices(
                    query = query,
                    size = size
                )
            )
        }
    }

    override suspend fun getStockPricesInOneDay(
        date: String
    ): Flow<Response<VNDirectResponse<StockPrice>>> {
        val query = "code:~date:gte:$date~date:lte:$date"

        return flow {
            emit(
                stockApi.getStockPricesInOneDay(
                    query = query
                )
            )
        }
    }

    override suspend fun getStockPricesInCurrentDay(): Flow<Response<VNDirectResponse<StockPrice>>> {
        val currentDateString = Date().currentDate()

        return getStockPricesInOneDay(currentDateString)
    }

    override suspend fun getAllStockPrices(code: String): Flow<Response<VNDirectResponse<StockPrice>>> {
        val startDateString = "2000-01-01"
        val currentDateString = Date().currentDate()

        val startDate = startDateString.toDate()
        val currentDate = currentDateString.toDate()
        val daysBetween = ChronoUnit.DAYS.between(startDate, currentDate)

        return getStockPrices(code, startDateString, currentDateString, daysBetween)
    }

    override fun getAllStockPricesFollowPage(
        code: String,
        stockDatabase: StockDatabase
    ): StockRemoteMediator {
        val startDateString = "2000-01-01"
        val currentDateString = Date().currentDate()

        val query = "code:$code~date:gte:$startDateString~date:lte:$currentDateString"

        return StockRemoteMediator(
            code,
            query,
            stockApi,
            stockDatabase
        )
    }
}