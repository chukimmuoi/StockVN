package com.chukimmuoi.data.api

import com.chukimmuoi.data.model.VNDirectResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 10/09/2022.
 */
/**
 * @see [guides.codepath.com](https://guides.codepath.com/android/Consuming-APIs-with-Retrofit)
 * */
interface StockApi {

    @GET("stock_prices")
    suspend fun getDateStock(
        @Query("sort") sort: String = "date",
        @Query("q") query: String = "code:MWG~date:gte:2000-01-01~date:lte:2022-09-10",
        @Query("size") size: Long = 50L,
        @Query("page") page: Long = 1L,
    ): Response<VNDirectResponse>
}