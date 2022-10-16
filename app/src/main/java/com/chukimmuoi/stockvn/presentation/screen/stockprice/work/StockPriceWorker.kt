package com.chukimmuoi.stockvn.presentation.screen.stockprice.work

import android.content.Context
import androidx.work.*
import com.chukimmuoi.data.model.StockPrice
import com.chukimmuoi.domain.usecase.MainUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 15/10/2022.
 */
class StockPriceWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val mainUseCase: MainUseCase
): CoroutineWorker(context, workerParameters) {

    companion object {

        const val CURRENT_DAY_KEY = "CURRENT_DAY"
        const val RESULT_DATA_KEY = "RESULT_DATA"
        const val PROGRESS_KEY = "PROGRESS"

        const val TAG_NAME_VALUE = "GET_STOCK_PRICE_WORKER"

        const val UNIQUE_NAME = "Get_Stock_Price_In_Current_Day"

        const val COUNT_RETRY = 5L
    }

    // Show notification Android < 12
    override suspend fun getForegroundInfo(): ForegroundInfo {
        return super.getForegroundInfo()
    }

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                val currentDayData = inputData.getString(CURRENT_DAY_KEY) ?: return@withContext Result.failure()
                Timber.i("Do Work Current Day: $currentDayData")

                val firstUpdate = workDataOf(PROGRESS_KEY to 0)
                setProgress(firstUpdate)

                mainUseCase.getStockPriceInCurrentDayUseCase<List<StockPrice>>()
                    .catch { e ->
                        e.printStackTrace()
                    }
                    .collect {
                        Timber.i("Get Stock Price In Current Day - Size: ${it.size}")
                    }

                val lastUpdate = workDataOf(PROGRESS_KEY to 100)
                setProgress(lastUpdate)

                val outputData = workDataOf(RESULT_DATA_KEY to "Success")
                return@withContext Result.success(outputData)
            } catch (e: Exception) {
                e.printStackTrace()

                if (runAttemptCount <= COUNT_RETRY) {
                    return@withContext Result.retry()
                } else {
                    return@withContext Result.failure()
                }
            }
        }
    }
}