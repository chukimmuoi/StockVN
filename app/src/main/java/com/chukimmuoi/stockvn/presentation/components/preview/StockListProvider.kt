package com.chukimmuoi.stockvn.presentation.components.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.chukimmuoi.data.model.Stock

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 01/10/2022.
 */
class StockListProvider: PreviewParameterProvider<List<Stock>> {
    override val values: Sequence<List<Stock>>
        get() = sequenceOf(
            listOf(
                Stock(
                    "HPG",
                    "HOUSE",
                    "Thép Hòa Phát"
                ),
                Stock(
                    "PNJ",
                    "HOUSE",
                    "Vàng bạc đá quá Phú Nhuận"
                ),
                Stock(
                    "MWG",
                    "HOUSE",
                    "Công ty cổ phần Thế Giới Di Động"
                )
            )
        )
}