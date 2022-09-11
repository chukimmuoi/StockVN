package com.chukimmuoi.data.db

import androidx.room.*
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
@Dao
interface DateStockInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dateStockInfo: DateStockInfo): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserts(dateStockInfo: List<DateStockInfo>): List<Long>

    @Query("SELECT EXISTS(SELECT * FROM date_stock_info WHERE code = :code)")
    suspend fun isExists(code: String): Boolean

    @Query("DELETE FROM date_stock_info WHERE code = :code")
    suspend fun delete(code: String): Int

    @Query("DELETE FROM date_stock_info")
    suspend fun deleteAll(): Int
}