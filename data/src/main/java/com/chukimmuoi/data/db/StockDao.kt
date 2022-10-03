package com.chukimmuoi.data.db

import androidx.paging.PagingSource
import androidx.room.*
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.data.model.StockWithStockPrice
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
    suspend fun insertOrUpdate(stock: Stock): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserts(stock: List<Stock>): List<Long>

    @Query("SELECT * FROM stock ORDER BY code ASC")
    fun getAll(): PagingSource<Int, Stock>

    @Query("SELECT * FROM stock WHERE isBookmarked AND NOT isPurchased ORDER BY code ASC")
    fun getAllBookmarked(): PagingSource<Int, Stock>

    @Query("SELECT * FROM stock WHERE isPurchased ORDER BY code ASC")
    fun getAllPurchased(): PagingSource<Int, Stock>

    @Query("SELECT EXISTS(SELECT * FROM stock)")
    fun isExists(): Flow<Boolean>

    @Delete
    suspend fun delete(stock: Stock): Int

    @Query("DELETE FROM stock")
    suspend fun deleteAll(): Int

    @Transaction
    @Query("SELECT * FROM stock")
    fun getStockWithStockPrice(): Flow<List<StockWithStockPrice>>
}