package com.chukimmuoi.data.util

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 02/09/2022.
 */
inline fun Int.isSuccess(action: () -> Unit): Boolean {
    val isSuccess = this > 0
    if (isSuccess) { action() }

    return isSuccess
}

inline fun Date.currentDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd")

    return sdf.format(this)
}

inline fun String.toDate(): LocalDate {
    val sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    return LocalDate.parse(this, sdf)
}