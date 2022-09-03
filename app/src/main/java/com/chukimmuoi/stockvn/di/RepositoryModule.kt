package com.chukimmuoi.stockvn.di

import android.app.Application
import com.chukimmuoi.data.repository.stock.StockRepositoryImpl
import com.chukimmuoi.data.repository.stock.datasource.StockCacheDataSource
import com.chukimmuoi.data.repository.stock.datasource.StockLocalDataSource
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
}