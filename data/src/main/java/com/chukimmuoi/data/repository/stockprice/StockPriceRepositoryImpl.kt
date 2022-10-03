package com.chukimmuoi.data.repository.stockprice

import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.model.StockPrice
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceCacheDataSource
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceLocalDataSource
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceRemoteDataSource
import com.chukimmuoi.data.repository.stockprice.datasourceimpl.StockPriceLocalDataSourceImpl
import com.chukimmuoi.domain.repository.StockPriceRepository
import kotlinx.coroutines.flow.*

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
class StockPriceRepositoryImpl(
    private val cache: StockPriceCacheDataSource,
    private val local: StockPriceLocalDataSource,
    private val remote: StockPriceRemoteDataSource
): StockPriceRepository {

    private val stockDatabase: StockDatabase by lazy {
        (local as StockPriceLocalDataSourceImpl).stockDatabase
    }

    override suspend fun <T> insert(stockPrice: T): Long {
        return local.save(stockPrice as StockPrice)
    }

    override suspend fun <T> inserts(stockPrices: List<T>): List<Long> {
        return local.save(stockPrices as List<StockPrice>)
    }

    override suspend fun <T> updateAllDataFromServer(code: String): Flow<T> {

        return flow { emit(remote.getAllStockPrices(code)) }
            .map { it.body() }
            .map { it?.data }
            .map {
                if (local.isExists(code)) local.clear(code)

                inserts(it as List<T>)
                it
            } as Flow<T>
    }

    override fun <T> updateAllDataFromServerWithPage(code: String): Flow<T> {
        val stockRemoteMediator = remote.getAllStockPricesFollowPage(code, stockDatabase)

        return local.getAllDataWithPage(code, stockRemoteMediator) as Flow<T>
    }

    override suspend fun <T> getQuery(): Flow<T> {
        TODO("Not yet implemented")
    }

    override suspend fun clear(code: String): Int {
        return local.clear(code)
    }

    override suspend fun clear(): Int {
        return local.clear()
    }
}