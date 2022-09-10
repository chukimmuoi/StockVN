package com.chukimmuoi.data.model

import androidx.room.Entity
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
    val nameCompany: String = ""
) {

    override fun toString(): String {
        return this.toJson()
    }
}