package com.chukimmuoi.stockvn.presentation.screen.stockprice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.chukimmuoi.data.model.StockPriceEntity
import com.chukimmuoi.domain.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
class StockPriceViewModel
@Inject constructor(
    private val app: Application,
    private val mainUseCase: MainUseCase
): AndroidViewModel(app) {

    lateinit var selectedStockPriceEntityPage: Flow<PagingData<StockPriceEntity>>

    var code: String by Delegates.observable("") { _, oldValue, newValue ->
        if (newValue != oldValue) {
            selectedStockPriceEntityPage = mainUseCase.updateStockPriceWithPageUseCase(newValue)
        }
    }

    private val _selectedStockPriceEntity: MutableStateFlow<List<StockPriceEntity>> = MutableStateFlow(listOf())
    val selectedStockPriceEntity: StateFlow<List<StockPriceEntity>> = _selectedStockPriceEntity

    fun getStockPriceData(code: String) {
        viewModelScope.launch {
            mainUseCase.updateStockPriceUseCase<List<StockPriceEntity>>(code)
                .catch { e ->
                    e.printStackTrace()
                }
                .collect {
                    _selectedStockPriceEntity.value = it
                }
        }
    }
}