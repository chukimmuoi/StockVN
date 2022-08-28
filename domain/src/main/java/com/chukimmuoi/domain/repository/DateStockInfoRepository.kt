package com.chukimmuoi.domain.repository

import com.chukimmuoi.domain.model.DateStockInfo
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

    suspend fun insert(dateStockInfo: DateStockInfo): Long

    suspend fun inserts(dateStockInfo: List<DateStockInfo>): List<Long>

    fun getAll(): Flow<List<DateStockInfo>>

    fun getQuery(): Flow<List<DateStockInfo>>

    suspend fun clear(): Boolean
}