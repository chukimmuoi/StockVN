package com.chukimmuoi.stockvn.presentation.screen.stock

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.chukimmuoi.data.model.StockEntity
import com.chukimmuoi.domain.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

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
    private val mainUseCase: MainUseCase
): AndroidViewModel(app) {

    lateinit var allStockEntity:Flow<PagingData<StockEntity>>

    var floor: String by Delegates.observable("") { _, oldValue, newValue ->
        if (newValue != oldValue || newValue.isEmpty()) {
            allStockEntity = mainUseCase.getStocksUseCase<PagingData<StockEntity>>(floor = newValue).cachedIn(viewModelScope)
        }
    }

    fun updateStock(stockEntity: StockEntity) {
        viewModelScope.launch {
            mainUseCase.updateStocksUseCase(stockEntity)
                .catch {

                }
                .collect {
                    it
                }
        }
    }
}