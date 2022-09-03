package com.chukimmuoi.stockvn.ui.stock

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.chukimmuoi.domain.usecase.ImportJsonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    private val importJsonUseCase: ImportJsonUseCase
): AndroidViewModel(app) {

    fun importFromCsv() {
        viewModelScope.launch(Dispatchers.IO) {
            importJsonUseCase("StockCode.json")
        }
    }
}