package com.chukimmuoi.stockvn.di

import com.chukimmuoi.data.repository.changeprice.datasource.ChangePriceCacheDataSource
import com.chukimmuoi.data.repository.changeprice.datasourceimpl.ChangePriceCacheDataSourceImpl
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceCacheDataSource
import com.chukimmuoi.data.repository.stockprice.datasourceimpl.StockPriceCacheDataSourceImpl
import com.chukimmuoi.data.repository.stock.datasource.StockCacheDataSource
import com.chukimmuoi.data.repository.stock.datasourceimpl.StockCacheDataSourceImpl
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
 * Created by chukimmuoi on 02/09/2022.
 */
@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {

    @Provides
    @Singleton
    fun provideStockCacheDataSource(): StockCacheDataSource {
        return StockCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideStockPriceCacheDataSource(): StockPriceCacheDataSource {
        return StockPriceCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideChangePriceCacheDataSource(): ChangePriceCacheDataSource {
        return ChangePriceCacheDataSourceImpl()
    }
}