package com.chukimmuoi.stockvn.presentation.components.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.chukimmuoi.data.model.StockEntity

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 01/10/2022.
 */
class StockListProvider: PreviewParameterProvider<List<StockEntity>> {
    override val values: Sequence<List<StockEntity>>
        get() = sequenceOf(
            listOf(
                StockEntity(
                    "HPG",
                    "HOUSE",
                    "Thép Hòa Phát"
                ),
                StockEntity(
                    "PNJ",
                    "HOUSE",
                    "Vàng bạc đá quá Phú Nhuận"
                ),
                StockEntity(
                    "MWG",
                    "HOUSE",
                    "Công ty cổ phần Thế Giới Di Động"
                )
            )
        )
}