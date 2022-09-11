package com.chukimmuoi.stockvn.presentation.screen.stock

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chukimmuoi.domain.usecase.StockUseCase
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
class StockViewModelFactory
@Inject constructor(
    private val app: Application,
    private val stockUseCase: StockUseCase
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StockViewModel(
            app,
            stockUseCase
        ) as T
    }
}