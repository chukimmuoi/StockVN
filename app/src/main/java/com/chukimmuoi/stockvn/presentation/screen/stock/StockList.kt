package com.chukimmuoi.stockvn.presentation.screen.stock

import androidx.compose.foundation.layout.*
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
import com.chukimmuoi.data.model.StockEntity
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
 * Created by chukimmuoi on 04/09/2022.
 */
@Composable
fun StockList(
    stocks: LazyPagingItems<StockEntity>,
    clickableGoTo: (StockEntity) -> Unit,
    clickableUpdate: (StockEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
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
                stockEntity = it,
                clickableGoTo = clickableGoTo,
                clickableUpdate = clickableUpdate
            )
        }
    }
}

@Preview
@Composable
fun StockListPreview(
    @PreviewParameter(StockListProvider::class) stockEntities: List<StockEntity>
) {
    StockVNTheme {
        StockList(
            stocks = flowOf(PagingData.from(stockEntities)).collectAsLazyPagingItems(),
            clickableGoTo = {},
            clickableUpdate = {}
        )
    }
}