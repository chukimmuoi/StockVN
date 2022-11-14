package com.chukimmuoi.stockvn.presentation.screen.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.work.*
import com.chukimmuoi.data.model.ChangePrice
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.data.util.currentDate
import com.chukimmuoi.domain.usecase.MainUseCase
import com.chukimmuoi.stockvn.presentation.screen.stockprice.work.StockPriceWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 01/10/2022.
 */
@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val app: Application,
    private val mainUseCase: MainUseCase
): AndroidViewModel(app) {

    init {
        getChangePrice()
        getStockPriceInCurrentDay()
    }

    val bookmarkedStocks: Flow<PagingData<Stock>> =
        mainUseCase.getBookmarkedStocksUseCase<PagingData<Stock>>().cachedIn(viewModelScope)

    val purchasedStocks: Flow<PagingData<Stock>> =
        mainUseCase.getPurchasedStocksUseCase<PagingData<Stock>>().cachedIn(viewModelScope)

    private val _changePrices: MutableStateFlow<List<ChangePrice>> = MutableStateFlow(listOf())
    val changePrice: StateFlow<List<ChangePrice>> = _changePrices

    fun updateStock(stock: Stock) {
        viewModelScope.launch {
            mainUseCase.updateStocksUseCase(stock)
                .catch {

                }
                .collect {
                    it
                }
        }
    }

    private fun getChangePrice() {
        viewModelScope.launch {
            mainUseCase.getChangePriceUseCase<List<ChangePrice>>()
                .catch {

                }
                .collect {
                    Timber.e("$it")
                    _changePrices.value = it
                }
        }
    }

    private fun getStockPriceInCurrentDay() {
        val data = workDataOf(
            StockPriceWorker.CURRENT_DAY_KEY to Date().currentDate()
        )

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(false)
            .setRequiresStorageNotLow(false)
            .setRequiresDeviceIdle(true)
            .build()

        val stockPriceWorkRequest =
            PeriodicWorkRequestBuilder<StockPriceWorker>(
                1, TimeUnit.HOURS,
                15, TimeUnit.MINUTES
            )
                .setInitialDelay(0L, TimeUnit.MILLISECONDS)
                .addTag(StockPriceWorker.TAG_NAME_VALUE)
                .setInputData(data)
                .setConstraints(constraints)
                // Use case retry. When use setBackoffCriteria not use setRequiresDeviceIdle(true)
                //.setBackoffCriteria(
                //    BackoffPolicy.EXPONENTIAL,
                //    PeriodicWorkRequest.MIN_BACKOFF_MILLIS,
                //    TimeUnit.MILLISECONDS
                //)
                .build()

        WorkManager.getInstance(app.applicationContext).apply {
            enqueueUniquePeriodicWork(
                StockPriceWorker.UNIQUE_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                stockPriceWorkRequest
            )
        }

        viewModelScope.launch {
            WorkManager
                .getInstance(app.applicationContext)
                .getWorkInfoByIdLiveData(stockPriceWorkRequest.id)
                .asFlow()
                .catch { e ->
                    e.printStackTrace()
                }
                .collect {
                    Timber.i("Get Stock Price In Current Day - Work Info: $it")
                    if (it != null) {
                        val progress = it.progress
                        val progressValue = progress.getInt(StockPriceWorker.PROGRESS_KEY, 0)
                        Timber.i("Get Stock Price In Current Day - Progress Value: $progressValue")

                        if (it.state == WorkInfo.State.ENQUEUED) {
                            val outputData = it.outputData.getString(StockPriceWorker.RESULT_DATA_KEY)
                            Timber.i("Get Stock Price In Current Day - Output Data: $outputData")
                        }
                    }
                }
            }
    }
}