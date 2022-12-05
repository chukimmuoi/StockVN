package com.chukimmuoi.data.api

import com.chukimmuoi.data.model.ChangePriceEntity
import com.chukimmuoi.data.model.StockPriceEntity
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
    suspend fun getStockPrices(
        @Query("sort") sort: String = "date",
        @Query("q") query: String = "code:MWG~date:gte:2000-01-01~date:lte:2022-09-10",
        @Query("size") size: Long = 50L,
        @Query("page") page: Long = 1L,
    ): Response<VNDirectResponse<StockPriceEntity>>

    @GET("stock_prices")
    suspend fun getStockPricesInOneDay(
        @Query("sort") sort: String = "date",
        @Query("q") query: String = "code:~date:gte:2022-09-10~date:lte:2022-09-10",
        @Query("size") size: Long = 9999L,
        @Query("page") page: Long = 1L,
    ): Response<VNDirectResponse<StockPriceEntity>>

    @GET("change_prices")
    suspend fun getChangePrices(
        @Query("q") query: String = "code:VNINDEX,HNX,UPCOM,VN30,VN30F1M,HNX30~period:1D",
    ): Response<VNDirectResponse<ChangePriceEntity>>
}