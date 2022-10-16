package com.chukimmuoi.stockvn.presentation.screen.stockprice.work

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.chukimmuoi.domain.usecase.MainUseCase

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 16/10/2022.
 */
class StockPriceWorkerFactory(
    private val mainUseCase: MainUseCase
): WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {

        return when(workerClassName) {
            StockPriceWorker::class.java.name -> StockPriceWorker(
                appContext,
                workerParameters,
                mainUseCase
            )
            else -> null
        }
    }
}