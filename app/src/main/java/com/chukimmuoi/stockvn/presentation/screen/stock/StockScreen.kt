package com.chukimmuoi.stockvn.presentation.screen.stock

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.chukimmuoi.data.model.Stock

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
fun StockScreen(
    stocks: LazyPagingItems<Stock>,
    clickable: (Stock) -> Unit,
    modifier: Modifier = Modifier
) {
    StockList(
        stocks = stocks,
        clickable = clickable
    )
}