package com.chukimmuoi.stockvn.di

import android.app.Application
import androidx.room.Room
import com.chukimmuoi.data.db.DateStockInfoDao
import com.chukimmuoi.data.db.StockDao
import com.chukimmuoi.data.db.StockDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
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
class DatabaseModule {

    @Provides
    @Singleton
    @Named("DatabaseName")
    fun provideDatabaseName(): String {
        return "Stock-VN"
    }

    @Provides
    @Singleton
    fun provideStockDatabase(
        application: Application,
        @Named("DatabaseName") databaseName: String
    ): StockDatabase {
        return Room
            .databaseBuilder(
                application,
                StockDatabase::class.java,
                databaseName
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideStockDao(database: StockDatabase): StockDao {
        return database.getStockDao()
    }

    @Provides
    @Singleton
    fun provideDateStockInfoDao(database: StockDatabase): DateStockInfoDao {
        return database.getDateStockInfoDao()
    }
}