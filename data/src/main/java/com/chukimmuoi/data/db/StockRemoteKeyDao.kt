package com.chukimmuoi.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chukimmuoi.data.model.StockRemoteKeys

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 22/09/2022.
 */
@Dao
interface StockRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(stockRemoteKey: List<StockRemoteKeys>)

    @Query("SELECT * FROM stock_remote_keys WHERE code = :code AND date = :date")
    suspend fun getRemoteKeysBy(
        code: String,
        date: String
    ): StockRemoteKeys?

    @Query("DELETE FROM stock_remote_keys WHERE code = :code")
    suspend fun clearRemoteKeys(code: String)

    @Query("DELETE FROM stock_remote_keys")
    suspend fun clearAll()
}