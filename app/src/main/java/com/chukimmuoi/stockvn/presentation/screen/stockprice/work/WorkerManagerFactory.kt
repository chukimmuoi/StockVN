package com.chukimmuoi.stockvn.presentation.screen.stockprice.work

import androidx.work.DelegatingWorkerFactory
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
class WorkerManagerFactory(
    mainUseCase: MainUseCase
): DelegatingWorkerFactory() {

    init {
        addFactory(StockPriceWorkerFactory(mainUseCase))
    }

}