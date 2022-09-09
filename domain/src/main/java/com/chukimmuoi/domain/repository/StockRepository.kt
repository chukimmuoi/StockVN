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

    suspend fun <T> insert(stock: T): Long

    suspend fun <T> insert(stocks: List<T>): List<Long>

    suspend fun <T> saveFavorite(stock: T): Long

    suspend fun <T> saveFavorites(stocks: List<T>): List<Long>

    suspend fun <T> removeFavorite(stock: T): Long

    suspend fun <T> removeFavorites(stocks: List<T>): List<Long>

    fun <T> search(keySearch: String): Flow<T>

    fun <T> getAllStock(): Flow<T>

    suspend fun clear(): Boolean
}