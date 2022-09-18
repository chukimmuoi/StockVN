package com.chukimmuoi.stockvn.presentation.screen.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.chukimmuoi.data.model.DateStockInfo
import com.chukimmuoi.domain.usecase.StockUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

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

    private val _selectedDateStockInfo: MutableStateFlow<List<DateStockInfo>> = MutableStateFlow(listOf())
    val selectedDateStockInfo: StateFlow<List<DateStockInfo>> = _selectedDateStockInfo

    fun getStockData(code: String) {
        viewModelScope.launch {
            stockUseCase.updateStockDateUseCase<List<DateStockInfo>>(code)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                }
                .collect {
                    _selectedDateStockInfo.value = it
                }
        }
    }
}