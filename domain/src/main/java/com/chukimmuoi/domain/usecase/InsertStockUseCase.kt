package com.chukimmuoi.domain.usecase

import com.chukimmuoi.domain.model.Stock
import com.chukimmuoi.domain.repository.StockRepository

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
class InsertStockUseCase(private val stockRepository: StockRepository) {

    suspend operator fun invoke(stock: Stock) = stockRepository.insert(stock)
}