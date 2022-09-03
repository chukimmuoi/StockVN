package com.chukimmuoi.data.util

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