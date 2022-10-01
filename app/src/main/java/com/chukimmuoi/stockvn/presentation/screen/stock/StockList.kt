package com.chukimmuoi.stockvn.presentation.screen.stock

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme
import kotlinx.coroutines.flow.flowOf

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
            items = stocks,
            key = { it.code }
        ) {
            StockItem(
                stock = it,
                clickableGoTo = clickableGoTo,
                clickableUpdate = clickableUpdate
            )
        }
    }
}

class StockListProvider: PreviewParameterProvider<List<Stock>> {
    override val values: Sequence<List<Stock>>
        get() = sequenceOf(
            listOf(
                Stock(
                    "HPG",
                    "HOUSE",
                    "Thép Hòa Phát"
                ),
                Stock(
                    "PNJ",
                    "HOUSE",
                    "Vàng bạc đá quá Phú Nhuận"
                ),
                Stock(
                    "MWG",
                    "HOUSE",
                    "Công ty cổ phần Thế Giới Di Động"
                )
            )
        )
}

@Preview
@Composable
fun StockListPreview(
    @PreviewParameter(StockListProvider::class) stocks: List<Stock>
) {
    StockVNTheme {
        StockList(
            stocks = flowOf(PagingData.from(stocks)).collectAsLazyPagingItems(),
            clickableGoTo = {},
            clickableUpdate = {}
        )
    }
}