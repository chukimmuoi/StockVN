package com.chukimmuoi.stockvn.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.core.designsystem.theme.StockVNTheme
import com.chukimmuoi.stockvn.presentation.components.preview.StockListProvider
import kotlinx.coroutines.flow.flowOf

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 01/10/2022.
 */
@Composable
fun PurchasedList(
    stockPages: LazyPagingItems<Stock>,
    clickableGoTo: (Stock) -> Unit,
    clickableUpdate: (Stock) -> Unit,
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
            items = stockPages,
            key = { it.code }
        ) {
            PurchasedItem(
                stock = it,
                clickableGoTo = clickableGoTo,
                clickableUpdate = clickableUpdate
            )
        }
    }
}

@Preview
@Composable
fun PurchasedListPreview(
    @PreviewParameter(StockListProvider::class) stocks: List<Stock>
) {
    StockVNTheme {
        PurchasedList(
            stockPages = flowOf(PagingData.from(stocks)).collectAsLazyPagingItems(),
            clickableGoTo = {},
            clickableUpdate = {}
        )
    }
}