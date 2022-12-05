package com.chukimmuoi.stockvn.presentation.screen.stockprice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.chukimmuoi.data.model.StockPriceEntity
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.core.designsystem.theme.StockVNTheme
import com.chukimmuoi.stockvn.presentation.components.preview.StockPriceProvider
import com.chukimmuoi.stockvn.presentation.components.annotation.ThemesPreviews

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 17/09/2022.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockPriceItem(
    stockPriceEntity: StockPriceEntity?,
    clickable: (StockPriceEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    if (stockPriceEntity == null) return

    val stateIcon = stockPriceEntity.handlerSateIcon(
        upAction = {
            Icons.Filled.ArrowDropUp
        },
        downAction = {
            Icons.Filled.ArrowDropDown
        },
        unchanged = {
            Icons.Filled.UnfoldMore
        }
    )

    val stateColor = stockPriceEntity.handlerSateColor()

    Card(
        onClick = { clickable(stockPriceEntity) },
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
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stockPriceEntity.close.toString(),
                    style = TextStyle(
                        color = stateColor,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = modifier.weight(0.3F)
                )
                Row(
                    modifier = modifier.weight(0.2F),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = stateIcon,
                        colorFilter = ColorFilter.tint(stateColor),
                        contentDescription = "State Icon")
                    Text(
                        text = stockPriceEntity.getPriceVolatility(),
                        style = TextStyle(
                            color = stateColor
                        ),
                    )
                }
                Text(
                    text = stockPriceEntity.date,
                    style = TextStyle(
                        textAlign = TextAlign.Right
                    ),
                    modifier = modifier.weight(0.25F)
                )
                Text(
                    text = stockPriceEntity.getVolume(),
                    style = TextStyle(
                        textAlign = TextAlign.Right
                    ),
                    modifier = modifier.weight(0.25F)
                )
            }
        }
    )
}

@ThemesPreviews
@Composable
fun StockItemPreview(@PreviewParameter(StockPriceProvider::class) stockPriceEntity: StockPriceEntity) {
    StockVNTheme {
        StockPriceItem(
            stockPriceEntity = stockPriceEntity,
            clickable = {}
        )
    }
}