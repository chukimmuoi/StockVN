package com.chukimmuoi.stockvn.compose.stock

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val color = listOf(Color.Green, Color.Red, Color.Blue, Color.Magenta).random()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(
            text = stock.code,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = color,
            modifier = modifier
                .fillMaxWidth(0.3F)
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stock.nameCompany,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier.padding(bottom = 4.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = stock.exchange,
                modifier = modifier.padding(top = 4.dp)
            )
        }
    }
}