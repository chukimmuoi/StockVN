package com.chukimmuoi.stockvn.di

import com.chukimmuoi.data.api.StockApi
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceRemoteDataSource
import com.chukimmuoi.data.repository.stockprice.datasourceimpl.StockPriceRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 10/09/2022.
 */
@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideStockRemoteDataSource(
        stockApi: StockApi
    ): StockPriceRemoteDataSource {
        return StockPriceRemoteDataSourceImpl(stockApi)
    }
}