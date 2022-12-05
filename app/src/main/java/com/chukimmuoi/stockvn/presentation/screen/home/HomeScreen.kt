package com.chukimmuoi.stockvn.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.chukimmuoi.stockvn.presentation.Screen

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 19/09/2022.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    openDrawer: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val bookmarkedStocks = viewModel.bookmarkedStocks.collectAsLazyPagingItems()
    val purchasedStocks = viewModel.purchasedStocks.collectAsLazyPagingItems()

    val changePrices by viewModel.changePriceEntity.collectAsState()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
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
                    changePriceEntities = changePrices,
                    clickableGoTo = {
                        navController.navigate(
                            route = Screen.Stock.passFloorCode(it.getCodeCustom())
                        )
                    },
                    modifier = modifier
                )
                BookmarkedList(
                    stockEntityPages = bookmarkedStocks,
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
                    stockEntityPages = purchasedStocks,
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