package com.chukimmuoi.stockvn.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.chukimmuoi.stockvn.presentation.Screen
import com.chukimmuoi.stockvn.ui.theme.appContentColor
import com.chukimmuoi.stockvn.ui.theme.appThemeColor

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 19/09/2022.
 */
@Composable
fun HomeScreen(
    openDrawer: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val bookmarkedStocks = viewModel.bookmarkedStocks.collectAsLazyPagingItems()
    val purchasedStocks = viewModel.purchasedStocks.collectAsLazyPagingItems()

    val changePrices by viewModel.changePrice.collectAsState()

    Scaffold(
        backgroundColor = MaterialTheme.colors.appThemeColor,
        contentColor = MaterialTheme.colors.appContentColor,
        topBar = {
            HomeTopBar(
                openDrawer = {
                    openDrawer()
                },
                modifier = modifier
            )
        },
        content = {
            Column(
                modifier = modifier.padding(it),
            ) {
                ChangePriceList(
                    changePrices = changePrices,
                    clickableGoTo = {
                        navController.navigate(
                            route = Screen.Stock.passFloorCode(it.getCodeCustom())
                        )
                    },
                    modifier = modifier
                )
                BookmarkedList(
                    stockPages = bookmarkedStocks,
                    clickableGoTo = {
                        navController.navigate(
                            route = Screen.StockPrices.passStockCode(it.code)
                        )
                    },
                    clickableUpdate = {
                        viewModel.updateStock(it)
                    }
                )
                PurchasedList(
                    stockPages = purchasedStocks,
                    clickableGoTo = {
                        navController.navigate(
                            route = Screen.StockPrices.passStockCode(it.code)
                        )
                    },
                    clickableUpdate = {
                        viewModel.updateStock(it)
                    }
                )
            }
        }
    )
}