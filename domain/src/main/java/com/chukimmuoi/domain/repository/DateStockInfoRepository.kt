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
interface DateStockInfoRepository {

    suspend fun <T> insert(dateStockInfo: T): Long

    suspend fun <T> inserts(dateStockInfo: List<T>): List<Long>

    suspend fun <T> updateAllDataFromServer(code: String): Flow<T>

    suspend fun <T> getQuery(): Flow<T>

    suspend fun clear(code: String): Int

    suspend fun clear(): Int
}