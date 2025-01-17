package com.chukimmuoi.domain.usecase

import com.chukimmuoi.domain.repository.StockRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 04/09/2022.
 */
class GetStocksUseCase(private val stockRepository: StockRepository) {

    operator fun <T> invoke(floor: String): Flow<T> = stockRepository.getAllStock(floor)
}

class GetBookmarkedStocksUseCase(private val stockRepository: StockRepository) {

    operator fun <T> invoke(): Flow<T> = stockRepository.getBookmarked()
}

class GetPurchasedStocksUseCase(private val stockRepository: StockRepository) {

    operator fun <T> invoke(): Flow<T> = stockRepository.getPurchased()
}

class UpdateStockUseCase(private val stockRepository: StockRepository) {

    suspend operator fun <T> invoke(stock: T): Flow<Long> = stockRepository.update(stock)
}