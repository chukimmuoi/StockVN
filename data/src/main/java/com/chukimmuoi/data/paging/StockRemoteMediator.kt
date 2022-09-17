package com.chukimmuoi.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.chukimmuoi.data.db.StockDao
import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.model.Stock

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 07/09/2022.
 */
@OptIn(ExperimentalPagingApi::class)
class StockRemoteMediator(
    private val stockDatabase: StockDatabase,
    private val stockDao: StockDao
) : RemoteMediator<Int, Stock>() {

    override suspend fun initialize(): InitializeAction {

        return InitializeAction.SKIP_INITIAL_REFRESH
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Stock>): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {

            }
            LoadType.PREPEND -> {

            }
            LoadType.APPEND -> {

            }
        }

        try {
            val endOfPaginationReached = false
            stockDatabase.withTransaction {

            }

            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }
}