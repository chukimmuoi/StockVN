package com.chukimmuoi.stockvn.presentation.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.chukimmuoi.data.model.StockEntity
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.StarButton
import com.chukimmuoi.core.designsystem.theme.StockVNTheme
import com.chukimmuoi.stockvn.presentation.components.preview.StockProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.chukimmuoi.stockvn.presentation.components.annotation.ThemesPreviews

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 01/10/2022.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchasedItem(
    stockEntity: StockEntity?,
    clickableGoTo: (StockEntity) -> Unit,
    clickableUpdate: (StockEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    if (stockEntity == null) return

    val color = listOf(Color.Green, Color.Red, Color.Blue, Color.Magenta).random()

    var stockIsPurchased by remember { stockEntity.stockIsPurchased }

    Card(
        onClick = { clickableGoTo(stockEntity) },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(
            dimensionResource(
                id = R.dimen.rounded_corner_shape_card_item
            )
        ),
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        dimensionResource(
                            id = R.dimen.padding_content_of_card_item
                        )
                    )
            ) {
                Text(
                    text = stockEntity.code,
                    style = TextStyle(
                        color = color,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = modifier
                )

                StarButton(
                    isStared = stockIsPurchased,
                    onClick = {
                        stockIsPurchased = it

                        clickableUpdate(stockEntity.apply { isPurchased = it })
                    },
                    modifier = modifier.clearAndSetSemantics {}
                )
            }
        }
    )
}

@ThemesPreviews
@Composable
fun PurchasedItemPreview(@PreviewParameter(StockProvider::class) stockEntity: StockEntity) {
    StockVNTheme {
        PurchasedItem(
            stockEntity = stockEntity,
            clickableGoTo = {},
            clickableUpdate = {}
        )
    }
}