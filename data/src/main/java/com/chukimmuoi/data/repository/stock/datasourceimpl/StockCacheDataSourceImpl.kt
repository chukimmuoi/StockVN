package com.chukimmuoi.data.repository.stock.datasourceimpl

import com.chukimmuoi.data.repository.stock.datasource.StockCacheDataSource
import com.chukimmuoi.domain.model.Stock

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

    override suspend fun getStock(): List<Stock> = stocks

    override suspend fun saveStock(stocks: List<Stock>) {
        this.stocks.addAll(stocks)
    }

    override suspend fun clear() {
        this.stocks.clear()
    }
}