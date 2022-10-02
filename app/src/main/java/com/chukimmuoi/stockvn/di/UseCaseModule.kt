package com.chukimmuoi.stockvn.di

import com.chukimmuoi.domain.repository.DateStockInfoRepository
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
    fun provideGetPurchasedStocksUseCase(
        stockRepository: StockRepository
    ): GetPurchasedStocksUseCase {
        return GetPurchasedStocksUseCase(stockRepository)
    }

    @Provides
    @Singleton
    fun provideGetBookmarkedStocksUseCase(
        stockRepository: StockRepository
    ): GetBookmarkedStocksUseCase {
        return GetBookmarkedStocksUseCase(stockRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateStocksUseCase(
        stockRepository: StockRepository
    ): UpdateStockUseCase {
        return UpdateStockUseCase(stockRepository)
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
    fun provideUpdateStockDateUseCase(
        dateStockInfoRepository: DateStockInfoRepository
    ): UpdateStockDateUseCase {
        return UpdateStockDateUseCase(dateStockInfoRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateStockDateFlowPageUseCase(
        dateStockInfoRepository: DateStockInfoRepository
    ): UpdateStockDateWithPageUseCase {
        return UpdateStockDateWithPageUseCase(dateStockInfoRepository)
    }

    @Provides
    @Singleton
    fun provideStockUseCase(
        getStocksUseCase: GetStocksUseCase,
        getBookmarkedStocksUseCase: GetBookmarkedStocksUseCase,
        getPurchasedStocksUseCase: GetPurchasedStocksUseCase,
        updateStockUseCase: UpdateStockUseCase,
        updateStockDateUseCase: UpdateStockDateUseCase,
        updateStockDateWithPageUseCase: UpdateStockDateWithPageUseCase
    ): StockUseCase {
        return StockUseCase(
            getStocksUseCase,
            getBookmarkedStocksUseCase,
            getPurchasedStocksUseCase,
            updateStockUseCase,
            updateStockDateUseCase,
            updateStockDateWithPageUseCase
        )
    }
}