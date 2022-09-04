package com.chukimmuoi.domain.usecase

import com.chukimmuoi.domain.repository.StockRepository

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

    operator fun invoke() = stockRepository.getAllStock()
}