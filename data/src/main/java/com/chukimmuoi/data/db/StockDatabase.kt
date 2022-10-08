package com.chukimmuoi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chukimmuoi.data.model.ChangePrice
import com.chukimmuoi.data.model.StockPrice
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.data.model.StockRemoteKeys

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
    entities = [
        Stock::class,
        StockPrice::class,
        StockRemoteKeys::class,
        ChangePrice::class
    ],
    version = 1,
    exportSchema = true
)
abstract class StockDatabase: RoomDatabase() {

    abstract fun getStockDao(): StockDao
    abstract fun getStockPriceDao(): StockPriceDao

    abstract fun getStockRemoteKeyDao(): StockRemoteKeyDao

    abstract fun getChangePriceDao(): ChangePriceDao
}