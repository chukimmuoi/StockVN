package com.chukimmuoi.stockvn.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.chukimmuoi.stockvn.compose.stock.StockScreen
import com.chukimmuoi.stockvn.ui.stock.StockViewModel
import com.chukimmuoi.stockvn.ui.stock.StockViewModelFactory

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 04/09/2022.
 */
@Composable
fun BaseScreen(
    factory: StockViewModelFactory,
    stockViewModel: StockViewModel = viewModel(factory = factory),
    modifier: Modifier = Modifier
) {
    val stocks = stockViewModel.getStock().collectAsLazyPagingItems()

    StockScreen(
        stocks = stocks
    )
}