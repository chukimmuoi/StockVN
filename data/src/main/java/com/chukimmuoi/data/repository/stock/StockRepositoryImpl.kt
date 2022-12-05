package com.chukimmuoi.data.repository.stock

import android.content.Context
import com.chukimmuoi.data.model.StockEntity
import com.chukimmuoi.data.repository.stock.datasource.StockCacheDataSource
import com.chukimmuoi.data.repository.stock.datasource.StockLocalDataSource
import com.chukimmuoi.data.util.getJsonDataFromAsset
import com.chukimmuoi.data.util.isSuccess
import com.chukimmuoi.domain.repository.StockRepository
import com.chukimmuoi.data.util.fromJsonList
import kotlinx.coroutines.Dispatchers
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
class StockRepositoryImpl(
    private val context: Context,
    private val cache: StockCacheDataSource,
    private val local: StockLocalDataSource
): StockRepository {

    override suspend fun importFromJson(fileName: String): Boolean {
        val data = context.getJsonDataFromAsset(fileName)

        if (data.isNullOrEmpty()) return false

        val stockEntities = data.fromJsonList<StockEntity>()
        if (stockEntities.isNullOrEmpty()) return false

        clear()
        return insert(stockEntities).isNotEmpty()
    }

    override suspend fun importFromCsv(fileName: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun <T> insert(stock: T): Long {
        TODO("Not yet implemented")
    }

    override suspend fun <T> update(stock: T): Flow<Long> {

        return local.updateStock(stock as StockEntity).flowOn(Dispatchers.IO)
    }

    override suspend fun <T> insert(stocks: List<T>): List<Long> {

        val savedIds = local.saveStock(stocks as List<StockEntity>)
        val isSuccess = savedIds.isNotEmpty()
        if (isSuccess) { cache.saveStock(stocks) }

        return savedIds
    }

    override fun <T> search(keySearch: String): Flow<T> {
        TODO("Not yet implemented")
    }

    override fun <T> getAllStock(floor: String): Flow<T> {
        return getFromLocal<T>(floor).flowOn(Dispatchers.IO)
    }

    override fun <T> getBookmarked(): Flow<T> {
        return local.getBookmarkedStock().flowOn(Dispatchers.IO) as Flow<T>
    }

    override fun <T> getPurchased(): Flow<T> {
        return local.getPurchasedStock().flowOn(Dispatchers.IO) as Flow<T>
    }

    private fun <T> getFromLocal(floor: String): Flow<T> {
        return local.isExists().flatMapConcat { isExists ->
            if (isExists) {
                val stocks = local.getStock(floor)
                return@flatMapConcat stocks as Flow<T>
            } else {
                val stocksImportFileName = "StockCode.json"

                if (importFromJson(stocksImportFileName)) {
                    return@flatMapConcat getFromLocal(floor)
                } else {
                    return@flatMapConcat flowOf()
                }
            }
        }
    }

    override suspend fun clear(): Boolean {
        return local.clear().isSuccess { cache.clear() }
    }
}