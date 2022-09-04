package com.chukimmuoi.stockvn.ui.stock

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.chukimmuoi.data.model.mapToData
import com.chukimmuoi.domain.usecase.GetStocksUseCase
import kotlinx.coroutines.flow.map

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 02/09/2022.
 */
class StockViewModel(
    private val app: Application,
    private val getStocksUseCase: GetStocksUseCase,
): AndroidViewModel(app) {

    fun getStock() = getStocksUseCase().map { it.map { it.mapToData() } }
}