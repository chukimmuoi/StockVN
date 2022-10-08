package com.chukimmuoi.domain.repository

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

    suspend fun <T> update(stock: T): Flow<Long>

    suspend fun <T> insert(stocks: List<T>): List<Long>

    fun <T> search(keySearch: String): Flow<T>

    fun <T> getAllStock(floor: String): Flow<T>

    fun <T> getBookmarked(): Flow<T>

    fun <T> getPurchased(): Flow<T>

    suspend fun clear(): Boolean
}