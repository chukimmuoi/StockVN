package com.chukimmuoi.stockvn.di

import com.chukimmuoi.data.api.StockApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
class NetModule {

    private val BASE_URL = "https://finfo-api.vndirect.com.vn/v4/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsAPIService(retrofit: Retrofit): StockApi {
        return retrofit.create(StockApi::class.java)
    }
}