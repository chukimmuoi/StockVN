package com.chukimmuoi.stockvn.di

import com.chukimmuoi.domain.repository.StockRepository
import com.chukimmuoi.domain.usecase.*
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
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetStocksUseCase(
        stockRepository: StockRepository
    ): GetStocksUseCase {
        return GetStocksUseCase(stockRepository)
    }

    @Provides
    @Singleton
    fun provideImportJsonUseCase(
        stockRepository: StockRepository
    ): ImportJsonUseCase {
        return ImportJsonUseCase(stockRepository)
    }

    @Provides
    @Singleton
    fun provideImportCsvUseCase(
        stockRepository: StockRepository
    ): ImportCsvUseCase {
        return ImportCsvUseCase(stockRepository)
    }

    @Provides
    @Singleton
    fun provideInsertListStockUseCase(
        stockRepository: StockRepository
    ): InsertListStockUseCase {
        return InsertListStockUseCase(stockRepository)
    }

    @Provides
    @Singleton
    fun provideInsertStockUseCase(
        stockRepository: StockRepository
    ): InsertStockUseCase {
        return InsertStockUseCase(stockRepository)
    }
}