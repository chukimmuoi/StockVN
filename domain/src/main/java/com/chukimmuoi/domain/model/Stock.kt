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
data class Stock(
    val code: String = "",
    val nameCompany: String = "",
    val exchange: String = ""
) {

    override fun toString(): String {
        return this.toJson()
    }
}