package com.chukimmuoi.data.model

import androidx.compose.runtime.mutableStateOf
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.chukimmuoi.data.util.toJson
import com.google.gson.annotations.SerializedName

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
@Entity(tableName = "stock")
data class Stock(
    @PrimaryKey
    @SerializedName("code")
    val code: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("floor")
    val floor: String = "",
    @SerializedName("status")
    val status: String = "",
    @SerializedName("companyName")
    val companyName: String = "",
    @SerializedName("companyNameEng")
    val companyNameEng: String = "",
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("listedDate")
    val listedDate: String = "",
    @SerializedName("delistedDate")
    val delistedDate: String = "",
    @SerializedName("companyId")
    val companyId: String = "",
    @SerializedName("isBookmarked")
    var isBookmarked: Boolean = false,
    @SerializedName("isPurchased")
    var isPurchased: Boolean = false,
    @SerializedName("indexCode")
    val indexCode: String = "",
    @SerializedName("isin")
    val isin: String = ""
) {
    @Ignore
    val stockIsPurchased = mutableStateOf(isPurchased)

    @Ignore
    val stockIsBookmarked = mutableStateOf(isBookmarked)

    override fun toString(): String {
        return this.toJson()
    }
}