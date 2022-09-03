package com.chukimmuoi.data.repository.stock

import android.content.Context
import com.chukimmuoi.data.repository.stock.datasource.StockCacheDataSource
import com.chukimmuoi.data.repository.stock.datasource.StockLocalDataSource
import com.chukimmuoi.data.util.getJsonDataFromAsset
import com.chukimmuoi.data.util.isSuccess
import com.chukimmuoi.domain.model.Stock
import com.chukimmuoi.domain.repository.StockRepository
import com.chukimmuoi.domain.util.fromJsonList
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
class StockRepositoryImpl(
    private val context: Context,
    private val cache: StockCacheDataSource,
    private val local: StockLocalDataSource
): StockRepository {

    override suspend fun importFromJson(fileName: String): Boolean {
        val data = context.getJsonDataFromAsset(fileName)

        if (data.isNullOrEmpty()) return false

        val stocks = data.fromJsonList<Stock>()
        if (stocks.isNullOrEmpty()) return false

        clear()
        return insert(stocks).isNotEmpty()
    }

    override suspend fun importFromCsv(fileName: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun insert(stock: Stock): Long {
        TODO("Not yet implemented")
    }

    override suspend fun insert(stocks: List<Stock>): List<Long> {

        val savedIds = local.saveStock(stocks)
        val isSuccess = savedIds.isNotEmpty()
        if (isSuccess) { cache.saveStock(stocks) }

        return savedIds
    }

    override suspend fun saveFavorite(stock: Stock): Long {
        TODO("Not yet implemented")
    }

    override suspend fun saveFavorites(stocks: List<Stock>): List<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavorite(stock: Stock): Long {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavorites(stocks: List<Stock>): List<Long> {
        TODO("Not yet implemented")
    }

    override fun search(keySearch: String): Flow<List<Stock>> {
        TODO("Not yet implemented")
    }

    override fun getAll(): Flow<List<Stock>> {
        TODO("Not yet implemented")
    }

    override suspend fun clear(): Boolean {
        return local.clear().isSuccess { cache.clear() }
    }
}