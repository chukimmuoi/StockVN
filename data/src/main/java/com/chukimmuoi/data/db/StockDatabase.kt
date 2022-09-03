package com.chukimmuoi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chukimmuoi.data.model.DateStockInfo
import com.chukimmuoi.data.model.Stock

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
@Database(
    entities = [Stock::class, DateStockInfo::class],
    version = 1,
    exportSchema = true
)
abstract class StockDatabase: RoomDatabase() {

    abstract fun getStockDao(): StockDao
    abstract fun getDateStockInfo(): DateStockInfoDao
}