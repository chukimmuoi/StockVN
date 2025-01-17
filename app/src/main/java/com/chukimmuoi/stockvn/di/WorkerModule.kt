package com.chukimmuoi.stockvn.di

import com.chukimmuoi.domain.usecase.MainUseCase
import com.chukimmuoi.stockvn.presentation.screen.stockprice.work.WorkerManagerFactory
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
 * Created by chukimmuoi on 16/10/2022.
 */
@Module
@InstallIn(SingletonComponent::class)
class WorkerModule {

    @Provides
    @Singleton
    fun provideWorkerManagerFactory(
        mainUseCase: MainUseCase
    ): WorkerManagerFactory {

        return WorkerManagerFactory(mainUseCase)
    }
}