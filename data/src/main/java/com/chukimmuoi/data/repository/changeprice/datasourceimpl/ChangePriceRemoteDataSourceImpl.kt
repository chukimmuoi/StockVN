package com.chukimmuoi.data.repository.changeprice.datasourceimpl

import com.chukimmuoi.data.api.StockApi
import com.chukimmuoi.data.model.ChangePriceEntity
import com.chukimmuoi.data.model.VNDirectResponse
import com.chukimmuoi.data.repository.changeprice.datasource.ChangePriceRemoteDataSource
import retrofit2.Response

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 04/10/2022.
 */
class ChangePriceRemoteDataSourceImpl(
    private val stockApi: StockApi
): ChangePriceRemoteDataSource {

    override suspend fun getChangePrices(
        vararg floors: String,
        time: String
    ): Response<VNDirectResponse<ChangePriceEntity>> {

        val query = "code:${floors.map { it }}~period:$time"

        return stockApi.getChangePrices(
            query = query
        )
    }
}