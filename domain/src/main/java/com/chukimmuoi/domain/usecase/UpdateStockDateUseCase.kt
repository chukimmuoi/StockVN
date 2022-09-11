package com.chukimmuoi.domain.usecase

import com.chukimmuoi.domain.repository.DateStockInfoRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 10/09/2022.
 */
class UpdateStockDateUseCase(private val dateStockInfoRepository: DateStockInfoRepository) {

    suspend operator fun <T> invoke(code: String): Flow<T> = dateStockInfoRepository.updateAllDataFromServer(code)
}