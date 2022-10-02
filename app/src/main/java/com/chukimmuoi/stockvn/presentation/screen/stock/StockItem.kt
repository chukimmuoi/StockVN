package com.chukimmuoi.stockvn.presentation.screen.stock

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.chukimmuoi.data.model.Stock
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.BookmarkButton
import com.chukimmuoi.stockvn.presentation.components.StarButton
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme
import com.chukimmuoi.stockvn.presentation.components.preview.StockProvider
import com.chukimmuoi.stockvn.presentation.components.annotation.ThemesPreviews

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
    stock: Stock?,
    clickableGoTo: (Stock) -> Unit,
    clickableUpdate: (Stock) -> Unit,
    modifier: Modifier = Modifier
) {
    if (stock == null) return

    val color = listOf(Color.Green, Color.Red, Color.Blue, Color.Magenta).random()

    val stockIsPurchased = remember { stock.stockIsPurchased }
    val stockIsBookmarked = remember { stock.stockIsBookmarked }

    Card(
        modifier = modifier.clickable { clickableGoTo(stock) },
        elevation = dimensionResource(
            id = R.dimen.elevation_of_card_item
        ),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    dimensionResource(
                        id = R.dimen.padding_content_of_card_item
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stock.code,
                style = TextStyle(
                    color = color,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = modifier
                    .weight(0.3F)
            )

            Column(
                modifier = modifier
                    .weight(0.6F)
            ) {
                Text(
                    text = stock.companyName,
                    style = MaterialTheme.typography.h6,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier.padding(
                        bottom = dimensionResource(
                            id = R.dimen.padding_text_of_card_item
                        )
                    ),
                )
                Text(
                    text = stock.floor,
                    style = MaterialTheme.typography.caption,
                    modifier = modifier.padding(
                        top = dimensionResource(
                            id = R.dimen.padding_text_of_card_item
                        )
                    )
                )
            }

            if (stockIsPurchased.value) {
                StarButton(
                    isStared = true,
                    onClick = {
                        stockIsPurchased.value = it

                        clickableUpdate(stock.apply { isPurchased = it })
                    },
                    modifier = modifier
                        .weight(0.1F)
                        .clearAndSetSemantics {}
                )
            } else {
                BookmarkButton(
                    isBookmarked = stockIsBookmarked.value,
                    onClick = {
                        stockIsBookmarked.value = it

                        clickableUpdate(stock.apply { isBookmarked = it })
                    },
                    modifier = modifier
                        .weight(0.1F)
                        .clearAndSetSemantics {}
                )
            }
        }
    }
}

@ThemesPreviews
@Composable
fun StockItemPreview(@PreviewParameter(StockProvider::class) stock: Stock) {
    StockVNTheme {
        StockItem(
            stock = stock,
            clickableGoTo = {},
            clickableUpdate = {}
        )
    }
}