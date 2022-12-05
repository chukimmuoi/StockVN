package com.chukimmuoi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chukimmuoi.data.model.ChangePriceEntity
import com.chukimmuoi.data.model.StockPriceEntity
import com.chukimmuoi.data.model.StockEntity
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
        StockEntity::class,
        StockPriceEntity::class,
        StockRemoteKeys::class,
        ChangePriceEntity::class
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