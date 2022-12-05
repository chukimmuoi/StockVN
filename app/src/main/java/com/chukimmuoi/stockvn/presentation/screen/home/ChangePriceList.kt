package com.chukimmuoi.stockvn.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.chukimmuoi.data.model.ChangePriceEntity
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.annotation.ThemesPreviews
import com.chukimmuoi.stockvn.presentation.components.preview.ChangePriceListProvider
import com.chukimmuoi.core.designsystem.theme.StockVNTheme

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 05/10/2022.
 */
@Composable
fun ChangePriceList(
    changePriceEntities: List<ChangePriceEntity>,
    clickableGoTo: (ChangePriceEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            dimensionResource(
                id = R.dimen.padding_content_of_list_card
            )
        ),
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(
                id = R.dimen.space_item_of_list_card
            )
        ),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(
                id = R.dimen.space_item_of_list_card
            )
        ),
        content = {
            items(changePriceEntities) { changePrice ->
                ChangePriceItem(
                    changePriceEntity = changePrice,
                    clickableGoTo = clickableGoTo
                )
            }
        }
    )
}

@ThemesPreviews
@Composable
fun ChangePriceListPreview(
    @PreviewParameter(ChangePriceListProvider::class) changePriceEntities: List<ChangePriceEntity>
) {
    StockVNTheme {
        ChangePriceList(
            changePriceEntities = changePriceEntities,
            clickableGoTo = {},
        )
    }
}