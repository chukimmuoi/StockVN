package com.chukimmuoi.data.util

import android.content.Context

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
inline fun Context.getJsonDataFromAsset(fileName: String): String {
    val output = try {
        assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
    return output
}