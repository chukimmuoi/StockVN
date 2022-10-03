package com.chukimmuoi.stockvn.presentation.screen.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.chukimmuoi.data.model.StockPrice
import com.chukimmuoi.domain.usecase.StockUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
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
 * Created by chukimmuoi on 17/09/2022.
 */
@HiltViewModel
class DetailsViewModel
@Inject constructor(
    private val app: Application,
    private val stockUseCase: StockUseCase
): AndroidViewModel(app) {

    lateinit var selectedStockPricePage: Flow<PagingData<StockPrice>>

    var code: String by Delegates.observable("") { _, oldValue, newValue ->
        if (newValue != oldValue) {
            selectedStockPricePage = stockUseCase.updateStockPriceWithPageUseCase(newValue)
        }
    }

    private val _selectedStockPrice: MutableStateFlow<List<StockPrice>> = MutableStateFlow(listOf())
    val selectedStockPrice: StateFlow<List<StockPrice>> = _selectedStockPrice

    fun getStockData(code: String) {
        viewModelScope.launch {
            stockUseCase.updateStockPriceUseCase<List<StockPrice>>(code)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                }
                .collect {
                    _selectedStockPrice.value = it
                }
        }
    }
}