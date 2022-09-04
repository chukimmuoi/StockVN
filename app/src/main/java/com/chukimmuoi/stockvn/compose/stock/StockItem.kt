package com.chukimmuoi.stockvn.compose.stock

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun StockItem(
    stock: Stock,
    modifier: Modifier = Modifier
) {
    Row {
        Text(text = stock.code)

        Column {
            Text(text = stock.exchange)
            Text(text = stock.nameCompany)
        }
    }
}