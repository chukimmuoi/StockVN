package com.chukimmuoi.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chukimmuoi.data.model.ChangePriceEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 07/10/2022.
 */
@Dao
interface ChangePriceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(changePriceEntity: ChangePriceEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserts(changePriceEntities: List<ChangePriceEntity>): List<Long>

    @Query("SELECT * FROM change_price")
    fun getAll(): Flow<List<ChangePriceEntity>>
}