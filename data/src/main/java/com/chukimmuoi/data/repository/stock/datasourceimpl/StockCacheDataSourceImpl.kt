package com.chukimmuoi.data.repository.stock.datasourceimpl

import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.data.repository.stock.datasource.StockCacheDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
class StockCacheDataSourceImpl: StockCacheDataSource {

    private var stocks = arrayListOf<Stock>()

    override fun getStock(): Flow<List<Stock>> = flowOf(stocks)

    override suspend fun saveStock(stocks: List<Stock>) {
        this.stocks.addAll(stocks)
    }

    override suspend fun clear() {
        this.stocks.clear()
    }
}