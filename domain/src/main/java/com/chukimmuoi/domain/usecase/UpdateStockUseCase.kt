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
 * Created by chukimmuoi on 01/10/2022.
 */
class UpdateStockUseCase(private val stockRepository: StockRepository) {

    suspend operator fun <T> invoke(stock: T): Flow<Long> = stockRepository.update(stock)
}