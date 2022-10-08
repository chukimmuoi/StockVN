package com.chukimmuoi.data.repository.changeprice.datasource

import com.chukimmuoi.data.model.ChangePrice
import com.chukimmuoi.data.model.VNDirectResponse
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
interface ChangePriceRemoteDataSource {

    suspend fun getChangePrices(
        vararg floors: String,
        time: String
    ): Response<VNDirectResponse<ChangePrice>>
}