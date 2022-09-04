package com.chukimmuoi.stockvn.compose.stock

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
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
fun StockList(
    stocks: State<List<Stock>>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            items = stocks.value,
            key = { it.code }
        ) {
            StockItem(
                stock = it
            )
        }
    }
}