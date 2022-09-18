package com.chukimmuoi.stockvn.presentation.screen.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.chukimmuoi.data.model.DateStockInfo
import com.chukimmuoi.stockvn.R
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import timber.log.Timber

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
    dateStockInfo: List<DateStockInfo>,
    clickable: (DateStockInfo) -> Unit,
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
            items = dateStockInfo,
            key = { it.date }
        ) {
            DetailsItem(
                dateStockInfo = it,
                clickable = clickable
            )
        }
    }
}