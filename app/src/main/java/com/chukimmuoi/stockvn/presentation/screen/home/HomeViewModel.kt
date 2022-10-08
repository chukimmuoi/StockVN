package com.chukimmuoi.stockvn.presentation.screen.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.chukimmuoi.data.model.ChangePrice
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.domain.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
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
}