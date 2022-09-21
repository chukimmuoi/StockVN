package com.chukimmuoi.stockvn.presentation

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 11/09/2022.
 */
sealed class Screen(val route: String) {
    companion object {
        const val CODE = "code"
    }
    object Home : Screen("home_screen")
    object Stock : Screen("stock_screen")
    object StockDetails : Screen("stock_details_screen/{$CODE}") {
        fun passStockCode(code: String) = "stock_details_screen/$code"
    }
}