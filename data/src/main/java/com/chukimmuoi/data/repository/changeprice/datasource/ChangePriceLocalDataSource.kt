package com.chukimmuoi.data.repository.changeprice.datasource

import com.chukimmuoi.data.model.ChangePriceEntity
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
interface ChangePriceLocalDataSource {

    suspend fun insertChangePrices(changePriceEntities: List<ChangePriceEntity>): List<Long>

    fun getChangePrices(): Flow<List<ChangePriceEntity>>
}