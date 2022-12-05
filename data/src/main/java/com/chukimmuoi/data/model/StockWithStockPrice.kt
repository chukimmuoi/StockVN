package com.chukimmuoi.data.model

import androidx.room.Embedded
import androidx.room.Relation

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 03/09/2022.
 */
data class StockWithStockPrice(
    @Embedded
    val stockEntity: StockEntity,
    @Relation(
        parentColumn = "code",
        entityColumn = "code"
    )
    val stockPriceEntity: List<StockPriceEntity>
)