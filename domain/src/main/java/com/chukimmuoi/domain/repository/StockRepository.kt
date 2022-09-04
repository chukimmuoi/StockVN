package com.chukimmuoi.domain.repository

import com.chukimmuoi.domain.model.Stock
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
interface StockRepository {

    suspend fun importFromJson(fileName: String): Boolean

    suspend fun importFromCsv(fileName: String): Boolean

    suspend fun insert(stock: Stock): Long

    suspend fun insert(stocks: List<Stock>): List<Long>

    suspend fun saveFavorite(stock: Stock): Long

    suspend fun saveFavorites(stocks: List<Stock>): List<Long>

    suspend fun removeFavorite(stock: Stock): Long

    suspend fun removeFavorites(stocks: List<Stock>): List<Long>

    fun search(keySearch: String): Flow<List<Stock>>

    fun getAllStock(): Flow<List<Stock>>

    suspend fun clear(): Boolean
}