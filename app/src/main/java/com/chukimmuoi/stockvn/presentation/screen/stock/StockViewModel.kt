package com.chukimmuoi.stockvn.presentation.screen.stock

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.domain.usecase.StockUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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
}