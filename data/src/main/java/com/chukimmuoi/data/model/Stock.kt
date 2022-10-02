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
    @SerializedName("exchange")
    val exchange: String = "",
    @SerializedName("nameCompany")
    val nameCompany: String = "",
    @SerializedName("isBookmarked")
    var isBookmarked: Boolean = false,
    @SerializedName("isPurchased")
    var isPurchased: Boolean = false
) {
    @Ignore
    val stockIsPurchased = mutableStateOf(isPurchased)

    @Ignore
    val stockIsBookmarked = mutableStateOf(isBookmarked)

    override fun toString(): String {
        return this.toJson()
    }
}