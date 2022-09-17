package com.chukimmuoi.stockvn.presentation.screen.stock

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.stockvn.ui.theme.appContentColor
import com.chukimmuoi.stockvn.ui.theme.appThemeColor

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
    actionBack: () -> Unit,
    actionSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.appThemeColor,
        contentColor = MaterialTheme.colors.appContentColor,
        topBar = {
            StockTopBar(
                actionBack = actionBack,
                actionSearch = actionSearch,
                modifier = modifier
            )
        },
        content = {
            StockList(
                stocks = stocks,
                clickable = clickable
            )
        }
    )
}