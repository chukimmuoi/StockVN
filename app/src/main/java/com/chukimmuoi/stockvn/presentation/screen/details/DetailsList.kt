package com.chukimmuoi.stockvn.presentation.screen.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.chukimmuoi.data.model.StockPrice
import com.chukimmuoi.stockvn.R
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 17/09/2022.
 */
@Composable
fun DetailsList(
    stockPrice: LazyPagingItems<StockPrice>,
    clickable: (StockPrice) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(
            dimensionResource(
                id = R.dimen.padding_content_of_list_card
            )
        ),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(
                id = R.dimen.space_item_of_list_card
            )
        )
    ) {
        items(
            items = stockPrice,
            key = { it.date }
        ) {
            DetailsItem(
                stockPrice = it,
                clickable = clickable
            )
        }
    }
}