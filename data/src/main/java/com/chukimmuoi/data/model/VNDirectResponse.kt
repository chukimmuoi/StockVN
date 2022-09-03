package com.chukimmuoi.data.model

import com.chukimmuoi.domain.util.toJson
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
data class VNDirectResponse(
    @SerializedName("currentPage")
    val currentPage: Int = 0,
    @SerializedName("data")
    val `data`: List<DateStockInfo> = listOf(),
    @SerializedName("size")
    val size: Int = 0,
    @SerializedName("totalElements")
    val totalElements: Int = 0,
    @SerializedName("totalPages")
    val totalPages: Int = 0
) {

    override fun toString(): String {
        return this.toJson()
    }
}