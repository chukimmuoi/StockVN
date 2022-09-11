package com.chukimmuoi.data.repository.datestockinfo.datasourceimpl

import com.chukimmuoi.data.db.DateStockInfoDao
import com.chukimmuoi.data.model.DateStockInfo
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockLocalDataSource

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
class DateStockLocalDataSourceImpl(
    private val dateStockInfoDao: DateStockInfoDao
): DateStockLocalDataSource {

    override suspend fun save(dateStockInfo: DateStockInfo): Long {
        return dateStockInfoDao.insert(dateStockInfo)
    }

    override suspend fun save(dateStockInfo: List<DateStockInfo>): List<Long> {
        return dateStockInfoDao.inserts(dateStockInfo)
    }

    override suspend fun isExists(code: String): Boolean {
        return dateStockInfoDao.isExists(code)
    }

    override suspend fun clear(code: String): Int {
        return dateStockInfoDao.delete(code)
    }

    override suspend fun clear(): Int {
        return dateStockInfoDao.deleteAll()
    }
}