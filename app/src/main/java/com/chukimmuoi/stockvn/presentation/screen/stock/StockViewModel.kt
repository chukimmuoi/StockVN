package com.chukimmuoi.stockvn.presentation.screen.stock

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.chukimmuoi.data.model.DateStockInfo
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.domain.usecase.StockUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 02/09/2022.
 */
@HiltViewModel
class StockViewModel
@Inject constructor(
    private val app: Application,
    private val stockUseCase: StockUseCase
): AndroidViewModel(app) {

    fun getStock():Flow<PagingData<Stock>> =
        stockUseCase.getStocksUseCase<PagingData<Stock>>().cachedIn(viewModelScope)

    fun getStockData(code: String) {
        viewModelScope.launch {
            stockUseCase.updateStockDateUseCase<List<DateStockInfo>>(code)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                }
                .collect {
                    Timber.e("$it")
                }
        }
    }
}