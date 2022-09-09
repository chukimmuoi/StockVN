package com.chukimmuoi.stockvn.compose.stock

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
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
    stocks: LazyPagingItems<Stock>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            items = stocks,
            key = { it.code }
        ) {
            Column {
                StockItem(
                    stock = it
                )
                Divider(color = Color.Gray)
            }
        }
    }
}