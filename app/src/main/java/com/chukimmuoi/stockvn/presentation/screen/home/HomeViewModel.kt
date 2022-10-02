package com.chukimmuoi.stockvn.presentation.screen.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.domain.usecase.StockUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
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
    private val stockUseCase: StockUseCase
): AndroidViewModel(app) {

    val bookmarkedStocks: Flow<PagingData<Stock>> =
        stockUseCase.getBookmarkedStocksUseCase<PagingData<Stock>>().cachedIn(viewModelScope)

    val purchasedStocks: Flow<PagingData<Stock>> =
        stockUseCase.getPurchasedStocksUseCase<PagingData<Stock>>().cachedIn(viewModelScope)

    fun updateStock(stock: Stock) {
        viewModelScope.launch {
            stockUseCase.updateStocksUseCase(stock)
                .catch {

                }
                .collect {
                    it
                }
        }
    }
}