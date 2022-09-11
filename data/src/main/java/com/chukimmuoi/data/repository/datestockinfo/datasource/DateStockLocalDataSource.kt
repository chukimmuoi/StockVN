package com.chukimmuoi.data.repository.datestockinfo.datasource

import com.chukimmuoi.data.model.DateStockInfo

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
interface DateStockLocalDataSource {

    suspend fun save(dateStockInfo: DateStockInfo): Long

    suspend fun save(dateStockInfo: List<DateStockInfo>): List<Long>

    suspend fun isExists(code: String): Boolean

    suspend fun clear(code: String): Int

    suspend fun clear(): Int
}