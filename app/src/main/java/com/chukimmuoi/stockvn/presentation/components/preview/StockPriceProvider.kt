package com.chukimmuoi.stockvn.presentation.components.preview

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import com.chukimmuoi.data.model.StockPrice

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 02/10/2022.
 */
class StockPriceProvider: CollectionPreviewParameterProvider<StockPrice>(
    listOf(
        StockPrice(
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
        StockPrice(
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