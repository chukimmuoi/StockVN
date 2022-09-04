package com.chukimmuoi.data.db

import androidx.room.*
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.data.model.StockWithDateInfo
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
@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stock: Stock): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserts(stock: List<Stock>): List<Long>

    @Query("SELECT * FROM stock")
    fun getAll(): Flow<List<Stock>>

    @Delete
    suspend fun delete(stock: Stock): Int

    @Query("DELETE FROM stock")
    suspend fun deleteAll(): Int

    @Transaction
    @Query("SELECT * FROM stock")
    fun getStockWithDateInfo(): Flow<List<StockWithDateInfo>>
}