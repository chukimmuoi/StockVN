package com.chukimmuoi.data.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import com.chukimmuoi.data.util.toJson
import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat
import java.text.NumberFormat

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
@Entity(
    tableName = "stock_price",
    primaryKeys = ["code", "date"]
)
data class StockPriceEntity(
    @SerializedName("adAverage")
    val adAverage: Double = 0.0,
    @SerializedName("adChange")
    val adChange: Double = 0.0,
    @SerializedName("adClose")
    val adClose: Double = 0.0,
    @SerializedName("adHigh")
    val adHigh: Double = 0.0,
    @SerializedName("adLow")
    val adLow: Double = 0.0,
    @SerializedName("adOpen")
    val adOpen: Double = 0.0,
    @SerializedName("average")
    val average: Double = 0.0,
    @SerializedName("basicPrice")
    val basicPrice: Double = 0.0,
    @SerializedName("ceilingPrice")
    val ceilingPrice: Double = 0.0,
    @SerializedName("change")
    val change: Double = 0.0,
    @SerializedName("close")
    val close: Double = 0.0,
    @SerializedName("code")
    val code: String = "",
    @SerializedName("date")
    val date: String = "",
    @SerializedName("floor")
    val floor: String = "",
    @SerializedName("floorPrice")
    val floorPrice: Double = 0.0,
    @SerializedName("high")
    val high: Double = 0.0,
    @SerializedName("low")
    val low: Double = 0.0,
    @SerializedName("nmValue")
    val nmValue: Double = 0.0,
    @SerializedName("nmVolume")
    val nmVolume: Double = 0.0,
    @SerializedName("open")
    val `open`: Double = 0.0,
    @SerializedName("pctChange")
    val pctChange: Double = 0.0,
    @SerializedName("ptValue")
    val ptValue: Double = 0.0,
    @SerializedName("ptVolume")
    val ptVolume: Double = 0.0,
    @SerializedName("time")
    val time: String = "",
    @SerializedName("type")
    val type: String = ""
) {

    fun getPrimaryKeys() = Pair(code, date)

    fun getPriceVolatility(): String {
        val value = close - open
        return String.format("%.2f", value)
    }

    fun getVolume(): String {
        val formatter: NumberFormat = DecimalFormat("#,###")
        return "${formatter.format(nmVolume)}K"
    }

    fun handlerSateIcon(
        upAction: () -> ImageVector,
        downAction: () -> ImageVector,
        unchanged: () -> ImageVector
    ): ImageVector {
        val value = close - open

        return if (value > 0) {
            upAction()
        } else if (value < 0){
            downAction()
        } else {
            unchanged()
        }
    }

    fun handlerSateColor(limitChange: Double = 7.0): Color {
        val blockOn = limitChange / 100 * 90
        val blockBelow = limitChange / 100 * 90 * -1

        val value = close - open
        val color = when {
            value <= blockBelow -> Color.Blue
            value < 0 -> Color.Red
            value > 0 -> Color.Green
            value >= blockOn -> Color.Magenta
            else -> Color.Gray
        }

        return color
    }

    override fun toString(): String {
        return this.toJson()
    }
}