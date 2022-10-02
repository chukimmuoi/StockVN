package com.chukimmuoi.domain.usecase

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 10/09/2022.
 */
data class StockUseCase(
    val getStocksUseCase: GetStocksUseCase,
    val getBookmarkedStocksUseCase: GetBookmarkedStocksUseCase,
    val getPurchasedStocksUseCase: GetPurchasedStocksUseCase,
    val updateStocksUseCase: UpdateStockUseCase,
    val updateStockDateUseCase: UpdateStockDateUseCase,
    val updateStockDateWithPageUseCase: UpdateStockDateWithPageUseCase
)