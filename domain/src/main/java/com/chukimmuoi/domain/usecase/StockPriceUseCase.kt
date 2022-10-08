package com.chukimmuoi.domain.usecase

import com.chukimmuoi.domain.repository.StockPriceRepository
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
class UpdateStockPriceUseCase(private val stockPriceRepository: StockPriceRepository) {

    suspend operator fun <T> invoke(code: String): Flow<T> = stockPriceRepository.updateAllDataFromServer(code)
}

class UpdateStockPriceWithPageUseCase(private val stockPriceRepository: StockPriceRepository) {

    operator fun <T> invoke(code: String): Flow<T> = stockPriceRepository.updateAllDataFromServerWithPage(code)
}