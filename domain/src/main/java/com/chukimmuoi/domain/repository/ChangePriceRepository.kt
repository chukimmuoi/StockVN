package com.chukimmuoi.domain.repository

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
interface ChangePriceRepository {

    suspend fun <T> getChangePrice(): Flow<T>
}