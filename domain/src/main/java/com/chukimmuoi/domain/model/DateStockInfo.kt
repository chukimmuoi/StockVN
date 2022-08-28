package com.chukimmuoi.domain.model

import com.chukimmuoi.domain.common.toJson

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
data class DateStockInfo(
    val adAverage: Double = 0.0,
    val adChange: Double = 0.0,
    val adClose: Double = 0.0,
    val adHigh: Double = 0.0,
    val adLow: Double = 0.0,
    val adOpen: Double = 0.0,
    val average: Double = 0.0,
    val basicPrice: Double = 0.0,
    val ceilingPrice: Double = 0.0,
    val change: Double = 0.0,
    val close: Double = 0.0,
    val code: String = "",
    val date: String = "",
    val floor: String = "",
    val floorPrice: Double = 0.0,
    val high: Double = 0.0,
    val low: Double = 0.0,
    val nmValue: Double = 0.0,
    val nmVolume: Double = 0.0,
    val `open`: Double = 0.0,
    val pctChange: Double = 0.0,
    val ptValue: Double = 0.0,
    val ptVolume: Double = 0.0,
    val time: String = "",
    val type: String = ""
) {

    override fun toString(): String {
        return this.toJson()
    }
}