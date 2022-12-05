package com.chukimmuoi.data.paging

import androidx.paging.*
import androidx.room.withTransaction
import com.chukimmuoi.data.api.StockApi
import com.chukimmuoi.data.db.StockPriceDao
import com.chukimmuoi.data.db.StockDatabase
import com.chukimmuoi.data.db.StockRemoteKeyDao
import com.chukimmuoi.data.model.StockPriceEntity
import com.chukimmuoi.data.model.StockRemoteKeys
import retrofit2.HttpException
import java.io.IOException

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 07/09/2022.
 */
private const val STARTING_PAGE_INDEX = 1

@OptIn(ExperimentalPagingApi::class)
class StockRemoteMediator(
    private val code: String,
    private val query: String,
    private val stockApi: StockApi,
    private val stockDatabase: StockDatabase
) : RemoteMediator<Int, StockPriceEntity>() {

    private val stockPriceDao: StockPriceDao by lazy { stockDatabase.getStockPriceDao() }

    private val stockRemoteKeyDao: StockRemoteKeyDao by lazy { stockDatabase.getStockRemoteKeyDao() }

    override suspend fun initialize(): InitializeAction {

        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, StockPriceEntity>): MediatorResult {

        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: STARTING_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                nextKey
            }
        }

        return try {
            val response = stockApi.getStockPrices(
                query = query,
                page = page.toLong(),
                size = state.config.pageSize.toLong()
            )
            var endOfPaginationReached = false
            if (response.isSuccessful) {
                val responseData = response.body()
                endOfPaginationReached = responseData == null
                responseData?.let {
                    stockDatabase.withTransaction {
                        if (loadType == LoadType.REFRESH) {
                            stockPriceDao.delete(code)
                            stockRemoteKeyDao.clearRemoteKeys(code)
                        }

                        val prevKey = if (page == STARTING_PAGE_INDEX) null else (page - 1)
                        val nextKey = if (endOfPaginationReached) null else (page + 1)

                        val keys = responseData.data.map {
                            StockRemoteKeys(
                                code = it.code,
                                date = it.date,
                                prevKey = prevKey,
                                nextKey = nextKey
                            )
                        }
                        stockRemoteKeyDao.insertAll(keys)
                        stockPriceDao.inserts(responseData.data)
                    }
                }
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, StockPriceEntity>
    ): StockRemoteKeys? {

        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.getPrimaryKeys()?.let { primaryKeys ->
                val (code, date) = primaryKeys
                stockRemoteKeyDao.getRemoteKeysBy(code, date)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, StockPriceEntity>
    ): StockRemoteKeys? {

        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.getPrimaryKeys()
            ?.let { primaryKeys ->
                val (code, date) = primaryKeys
                stockRemoteKeyDao.getRemoteKeysBy(code, date)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, StockPriceEntity>
    ): StockRemoteKeys? {

        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.getPrimaryKeys()
            ?.let { primaryKeys ->
                val (code, date) = primaryKeys
                stockRemoteKeyDao.getRemoteKeysBy(code, date)
            }
    }
}