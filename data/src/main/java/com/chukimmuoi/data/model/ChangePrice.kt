package com.chukimmuoi.data.model


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "change_price")
data class ChangePrice(
    @PrimaryKey
    @SerializedName("code")
    val code: String = "",
    @SerializedName("bopPrice")
    val bopPrice: Double = 0.0,
    @SerializedName("change")
    val change: Double = 0.0,
    @SerializedName("changePct")
    val changePct: Double = 0.0,
    @SerializedName("lastUpdated")
    val lastUpdated: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("period")
    val period: String = "",
    @SerializedName("price")
    val price: Double = 0.0,
    @SerializedName("type")
    val type: String = ""
) {
    companion object {
        const val VNINDEX_VALUE = "VNINDEX"
        const val HOSE_VALUE = "HOSE"
        const val HNX_VALUE = "HNX"
        const val UPCOM_VALUE = "UPCOM"
        const val VN30_VALUE = "VN30"
        const val VN30F1M_VALUE = "VN30F1M"
        const val HNX30_VALUE = "HNX30"

        const val TIME_VALUE = "1D"
    }

    fun priceDisplay(): String {
        return String.format("%.1f", price)
    }

    fun changeDisplay(): String {
        return String.format("%.2f", change)
    }

    fun changePercentDisplay(): String {
        return "${String.format("%.1f", changePct)}%"
    }

    fun handlerSateIcon(
        upAction: () -> ImageVector,
        downAction: () -> ImageVector,
        unchanged: () -> ImageVector
    ): ImageVector {
        val value = price - bopPrice

        return if (value > 0) {
            upAction()
        } else if (value < 0){
            downAction()
        } else {
            unchanged()
        }
    }

    fun handlerSateColor(): Color {
        val value = price - bopPrice

        val color = when {
            value < 0 -> Color.Red
            value > 0 -> Color.Green
            else -> Color.Gray
        }

        return color
    }

    fun getCodeCustom(): String {

        return when(code) {
            VNINDEX_VALUE -> HOSE_VALUE
            VN30F1M_VALUE -> VN30_VALUE
            else -> code
        }
    }
}