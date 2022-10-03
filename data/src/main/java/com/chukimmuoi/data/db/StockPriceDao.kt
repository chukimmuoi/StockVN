package com.chukimmuoi.data.db

import androidx.paging.PagingSource
import androidx.room.*
import com.chukimmuoi.data.model.StockPrice

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
interface StockPriceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stockPrice: StockPrice): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserts(stockPrice: List<StockPrice>): List<Long>

    @Query("SELECT EXISTS(SELECT * FROM stock_price WHERE code = :code)")
    suspend fun isExists(code: String): Boolean

    @Query("SELECT * FROM stock_price WHERE code = :code ORDER BY date DESC")
    fun selectAllDataWithPage(code: String): PagingSource<Int, StockPrice>

    @Query("DELETE FROM stock_price WHERE code = :code")
    suspend fun delete(code: String): Int

    @Query("DELETE FROM stock_price")
    suspend fun deleteAll(): Int
}