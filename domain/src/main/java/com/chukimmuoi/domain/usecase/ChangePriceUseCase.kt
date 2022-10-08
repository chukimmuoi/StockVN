package com.chukimmuoi.domain.usecase

import com.chukimmuoi.domain.repository.ChangePriceRepository
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
class GetChangePriceUseCase(private val changePriceRepository: ChangePriceRepository) {

    suspend operator fun <T> invoke(): Flow<T> = changePriceRepository.getChangePrice()
}