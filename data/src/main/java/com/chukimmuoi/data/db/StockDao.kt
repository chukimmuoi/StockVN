package com.chukimmuoi.data.db

import androidx.paging.PagingSource
import androidx.room.*
import com.chukimmuoi.data.model.StockEntity
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
    suspend fun insertOrUpdate(stockEntity: StockEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserts(stockEntity: List<StockEntity>): List<Long>

    @Query("SELECT * FROM stock WHERE floor = :floor OR indexCode = :floor ORDER BY code ASC")
    fun getAllOrFloor(floor: String): PagingSource<Int, StockEntity>

    @Query("SELECT * FROM stock WHERE isBookmarked AND NOT isPurchased ORDER BY code ASC")
    fun getAllBookmarked(): PagingSource<Int, StockEntity>

    @Query("SELECT * FROM stock WHERE isPurchased ORDER BY code ASC")
    fun getAllPurchased(): PagingSource<Int, StockEntity>

    @Query("SELECT EXISTS(SELECT * FROM stock)")
    fun isExists(): Flow<Boolean>

    @Delete
    suspend fun delete(stockEntity: StockEntity): Int

    @Query("DELETE FROM stock")
    suspend fun deleteAll(): Int

    @Transaction
    @Query("SELECT * FROM stock")
    fun getStockWithStockPrice(): Flow<List<StockWithStockPrice>>
}