package com.chukimmuoi.stockvn.presentation.screen.stock

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
 * Created by chukimmuoi on 04/09/2022.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockScreen(
    viewModel: StockViewModel = hiltViewModel(),
    navController: NavHostController,
    floor: String = Screen.ALL_FLOOR_STOCK,
    modifier: Modifier = Modifier
) {
    viewModel.floor = floor
    val stocks = viewModel.allStock.collectAsLazyPagingItems()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        topBar = {
            StockTopBar(
                actionBack = {
                    navController.popBackStack()
                },
                actionSearch = {

                },
                title = floor,
                modifier = modifier
            )
        },
        content = {
            StockList(
                stocks = stocks,
                clickableGoTo = {
                    navController.navigate(route = Screen.StockPrices.passStockCode(it.code))
                },
                clickableUpdate = {
                    viewModel.updateStock(it)
                },
                modifier = modifier.padding(it)
            )
        }
    )
}