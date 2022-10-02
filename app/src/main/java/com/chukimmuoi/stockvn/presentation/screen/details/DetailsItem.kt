package com.chukimmuoi.stockvn.presentation.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import com.chukimmuoi.data.model.DateStockInfo
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme
import com.chukimmuoi.stockvn.presentation.components.preview.DateStockInfoProvider
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
@Composable
fun DetailsItem(
    dateStockInfo: DateStockInfo?,
    clickable: (DateStockInfo) -> Unit,
    modifier: Modifier = Modifier
) {
    if (dateStockInfo == null) return

    val stateIcon = dateStockInfo.handlerSateIcon(
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

    val stateColor = dateStockInfo.handlerSateColor()

    Card(
        modifier = modifier.clickable { clickable(dateStockInfo) },
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
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = dateStockInfo.close.toString(),
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
                    text = dateStockInfo.getPriceVolatility(),
                    style = TextStyle(
                        color = stateColor
                    ),
                )
            }
            Text(
                text = dateStockInfo.date,
                style = TextStyle(
                    textAlign = TextAlign.Right
                ),
                modifier = modifier.weight(0.25F)
            )
            Text(
                text = dateStockInfo.getVolume(),
                style = TextStyle(
                    textAlign = TextAlign.Right
                ),
                modifier = modifier.weight(0.25F)
            )
        }
    }
}

@ThemesPreviews
@Composable
fun StockItemPreview(@PreviewParameter(DateStockInfoProvider::class) dateStockInfo: DateStockInfo) {
    StockVNTheme {
        DetailsItem(
            dateStockInfo = dateStockInfo,
            clickable = {}
        )
    }
}