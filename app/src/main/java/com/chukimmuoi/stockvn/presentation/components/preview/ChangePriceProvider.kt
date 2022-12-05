package com.chukimmuoi.stockvn.presentation.components.preview

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import com.chukimmuoi.data.model.ChangePriceEntity

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 05/10/2022.
 */
class ChangePriceProvider : CollectionPreviewParameterProvider<ChangePriceEntity>(

    listOf(
        ChangePriceEntity(
            code = "VNINDEX",
            name = "VNINDEX",
            type = "INDEX",
            period = "1D",
            price = 1104.26,
            bopPrice = 1078.14,
            change = 26.12,
            changePct = 2.4226909306769064,
            lastUpdated = "2022-10-05 15:10"
        ),
        ChangePriceEntity(
            code = "VN30",
            name = "VN30",
            type = "INDEX",
            period = "1D",
            price = 1117.38,
            bopPrice = 1097.72,
            change = 19.66,
            changePct = 1.7909849506249316,
            lastUpdated = "2022-10-05 15:10"
        )
    )
)