package com.chukimmuoi.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 22/09/2022.
 */
@Entity(
    tableName = "stock_remote_keys",
    primaryKeys = ["code", "date"]
)
data class StockRemoteKeys(
    @SerializedName("code")
    val code: String = "",

    @SerializedName("date")
    val date: String = "",

    @SerializedName("prevKey")
    val prevKey: Int?,

    @SerializedName("nextKey")
    val nextKey: Int?
)