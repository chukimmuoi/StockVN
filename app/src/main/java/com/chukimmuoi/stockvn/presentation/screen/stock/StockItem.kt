package com.chukimmuoi.stockvn.presentation.screen.stock

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.chukimmuoi.data.model.StockEntity
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.BookmarkButton
import com.chukimmuoi.stockvn.presentation.components.StarButton
import com.chukimmuoi.core.designsystem.theme.StockVNTheme
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockItem(
    stockEntity: StockEntity?,
    clickableGoTo: (StockEntity) -> Unit,
    clickableUpdate: (StockEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    if (stockEntity == null) return

    val color = listOf(Color.Green, Color.Red, Color.Blue, Color.Magenta).random()

    val stockIsPurchased = remember { stockEntity.stockIsPurchased }
    val stockIsBookmarked = remember { stockEntity.stockIsBookmarked }

    Card(
        onClick = { clickableGoTo(stockEntity) },
        shape = RoundedCornerShape(
            dimensionResource(
                id = R.dimen.rounded_corner_shape_card_item
            )
        ),
        content = {
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
                    text = stockEntity.code,
                    color = color,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = modifier
                        .weight(0.3F)
                )

                Column(
                    modifier = modifier
                        .weight(0.6F)
                ) {
                    Text(
                        text = stockEntity.companyName,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = modifier.padding(
                            bottom = dimensionResource(
                                id = R.dimen.padding_text_of_card_item
                            )
                        ),
                    )
                    Text(
                        text = stockEntity.floor,
                        style = MaterialTheme.typography.bodyMedium,
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

                            clickableUpdate(stockEntity.apply { isPurchased = it })
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

                            clickableUpdate(stockEntity.apply { isBookmarked = it })
                        },
                        modifier = modifier
                            .weight(0.1F)
                            .clearAndSetSemantics {}
                    )
                }
            }
        }
    )
}

@ThemesPreviews
@Composable
fun StockItemPreview(@PreviewParameter(StockProvider::class) stockEntity: StockEntity) {
    StockVNTheme {
        StockItem(
            stockEntity = stockEntity,
            clickableGoTo = {},
            clickableUpdate = {}
        )
    }
}