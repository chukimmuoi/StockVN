package com.chukimmuoi.stockvn.di

import com.chukimmuoi.data.db.StockDao
import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.repository.datestockinfo.datasource.DateStockLocalDataSource
import com.chukimmuoi.data.repository.datestockinfo.datasourceimpl.DateStockLocalDataSourceImpl
import com.chukimmuoi.data.repository.stock.datasource.StockLocalDataSource
import com.chukimmuoi.data.repository.stock.datasourceimpl.StockLocalDataSourceImpl
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
class LocalDataModule {

    @Provides
    @Singleton
    fun provideStockLocalDataSource(
        stockDao: StockDao
    ): StockLocalDataSource {
        return StockLocalDataSourceImpl(stockDao)
    }

    @Provides
    @Singleton
    fun provideDateStockLocalDataSource(
        stockDatabase: StockDatabase
    ): DateStockLocalDataSource {
        return DateStockLocalDataSourceImpl(stockDatabase)
    }
}