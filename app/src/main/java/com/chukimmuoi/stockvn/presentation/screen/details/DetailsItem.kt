package com.chukimmuoi.stockvn.presentation.screen.details

import android.content.res.Configuration
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.sp
import com.chukimmuoi.data.model.DateStockInfo
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme

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

class DateStockInfoProvider: CollectionPreviewParameterProvider<DateStockInfo>(
    listOf(
        DateStockInfo(
            code = "DC2",
            date = "2022-09-16",
            time = "15:09:03",
            floor = "HNX",
            type = "STOCK",
            basicPrice = 9.4,
            ceilingPrice = 10.3,
            floorPrice = 8.5,
            open = 8.6,
            high = 9.1,
            low = 8.5,
            close = 8.9,
            average = 8.602,
            adOpen = 8.6,
            adHigh = 9.1,
            adLow = 8.5,
            adClose = 8.9,
            adAverage = 8.602,
            nmVolume = 4206.0,
            nmValue = 36181600.0,
            ptVolume = 0.0,
            ptValue = 0.0,
            change = -0.5,
            adChange = -0.5,
            pctChange = -5.3191
        ),
        DateStockInfo(
            code = "DC2",
            date = "2022-09-15",
            time = "15:09:02",
            floor = "HNX",
            type = "STOCK",
            basicPrice = 9.5,
            ceilingPrice = 10.4,
            floorPrice = 8.6,
            open = 9.5,
            high = 9.5,
            low = 8.9,
            close = 9.4,
            average = 9.13,
            adOpen = 9.5,
            adHigh = 9.5,
            adLow = 8.9,
            adClose = 9.4,
            adAverage = 9.13,
            nmVolume = 2797.0,
            nmValue = 25497800.0,
            ptVolume = 0.0,
            ptValue = 0.0,
            change = -0.1,
            adChange = -0.1,
            pctChange = -1.0526
        ),
    )
)

@Preview(
    name = "UI_MODE_NIGHT_NO",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "UI_MODE_NIGHT_YES",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun StockItemPreview(@PreviewParameter(DateStockInfoProvider::class) dateStockInfo: DateStockInfo) {
    StockVNTheme {
        DetailsItem(
            dateStockInfo = dateStockInfo,
            clickable = {}
        )
    }
}