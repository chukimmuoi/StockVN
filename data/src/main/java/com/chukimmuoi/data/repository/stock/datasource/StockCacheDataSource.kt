package com.chukimmuoi.data.repository.stock.datasource

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
interface StockCacheDataSource {

    suspend fun getStock(): List<Stock>

    suspend fun saveStock(stocks: List<Stock>)

    suspend fun clear()
}