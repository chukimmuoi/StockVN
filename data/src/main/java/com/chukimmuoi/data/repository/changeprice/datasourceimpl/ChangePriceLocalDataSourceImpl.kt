package com.chukimmuoi.data.repository.changeprice.datasourceimpl

import com.chukimmuoi.data.db.ChangePriceDao
import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.model.ChangePrice
import com.chukimmuoi.data.repository.changeprice.datasource.ChangePriceLocalDataSource
import kotlinx.coroutines.flow.Flow

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 04/10/2022.
 */
class ChangePriceLocalDataSourceImpl(
    private val stockDatabase: StockDatabase
): ChangePriceLocalDataSource {

    private val changePriceDao: ChangePriceDao by lazy {
        stockDatabase.getChangePriceDao()
    }

    override suspend fun insertChangePrices(changePrices: List<ChangePrice>): List<Long> {

        return changePriceDao.inserts(changePrices)
    }

    override fun getChangePrices(): Flow<List<ChangePrice>> {
        return changePriceDao.getAll()
    }
}