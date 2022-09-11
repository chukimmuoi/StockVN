package com.chukimmuoi.data.repository.datestockinfo.datasourceimpl

import com.chukimmuoi.data.api.StockApi
import com.chukimmuoi.data.model.VNDirectResponse
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockRemoteDataSource
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
class DateStockRemoteDataSourceImpl(
    private val stockApi: StockApi
): DateStockRemoteDataSource {

    private fun getCurrentDateString(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")

        return sdf.format(Date())
    }

    private fun getDateFromString(date: String): LocalDate {
        val sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        return LocalDate.parse(date, sdf)
    }

    override suspend fun getDateStock(
        code: String,
        fromDate: String,
        toDate: String,
        size: Long
    ): Response<VNDirectResponse> {
        val query = "code:$code~date:gte:$fromDate~date:lte:$toDate"

        return stockApi.getAllStockDate(
            query = query,
            size = size
        )
    }

    override suspend fun getAllDateStock(code: String): Response<VNDirectResponse> {
        val startDateString = "2000-01-01"
        val currentDateString = getCurrentDateString()

        val startDate = getDateFromString(startDateString)
        val currentDate = getDateFromString(currentDateString)
        val daysBetween = ChronoUnit.DAYS.between(startDate, currentDate)

        return getDateStock(code, startDateString, currentDateString, daysBetween)
    }
}