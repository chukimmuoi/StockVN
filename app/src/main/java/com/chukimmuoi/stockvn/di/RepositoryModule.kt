package com.chukimmuoi.stockvn.di

import android.app.Application
import com.chukimmuoi.data.repository.changeprice.ChangePriceRepositoryImpl
import com.chukimmuoi.data.repository.changeprice.datasource.ChangePriceCacheDataSource
import com.chukimmuoi.data.repository.changeprice.datasource.ChangePriceLocalDataSource
import com.chukimmuoi.data.repository.changeprice.datasource.ChangePriceRemoteDataSource
import com.chukimmuoi.data.repository.stockprice.StockPriceRepositoryImpl
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceCacheDataSource
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceLocalDataSource
import com.chukimmuoi.data.repository.stockprice.datasource.StockPriceRemoteDataSource
import com.chukimmuoi.data.repository.stock.StockRepositoryImpl
import com.chukimmuoi.data.repository.stock.datasource.StockCacheDataSource
import com.chukimmuoi.data.repository.stock.datasource.StockLocalDataSource
import com.chukimmuoi.domain.repository.ChangePriceRepository
import com.chukimmuoi.domain.repository.StockPriceRepository
import com.chukimmuoi.domain.repository.StockRepository
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
class RepositoryModule {

    @Provides
    @Singleton
    fun provideStockRepository(
        application: Application,
        stockCacheDataSource: StockCacheDataSource,
        stockLocalDataSource: StockLocalDataSource
    ): StockRepository {

        return StockRepositoryImpl(
            application,
            stockCacheDataSource,
            stockLocalDataSource
        )
    }

    @Provides
    @Singleton
    fun provideStockPriceRepository(
        stockPriceCacheDataSource: StockPriceCacheDataSource,
        stockPriceLocalDataSource: StockPriceLocalDataSource,
        stockPriceRemoteDataSource: StockPriceRemoteDataSource
    ): StockPriceRepository {

        return StockPriceRepositoryImpl(
            stockPriceCacheDataSource,
            stockPriceLocalDataSource,
            stockPriceRemoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideChangePriceRepository(
        changePriceCacheDataSource: ChangePriceCacheDataSource,
        changePriceLocalDataSource: ChangePriceLocalDataSource,
        changePriceRemoteDataSource: ChangePriceRemoteDataSource
    ): ChangePriceRepository {

        return ChangePriceRepositoryImpl(
            changePriceCacheDataSource,
            changePriceLocalDataSource,
            changePriceRemoteDataSource
        )
    }
}