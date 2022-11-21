package com.chukimmuoi.stockvn.presentation.screen.stockprice

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 17/09/2022.
 */
/**
 * @see [compose-navigation](https://developer.android.com/jetpack/compose/navigation)
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockPriceScreen(
    stock: String,
    navController: NavController,
    viewModel: StockPriceViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {

    viewModel.code = stock
    val stockPrice = viewModel.selectedStockPricePage.collectAsLazyPagingItems()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        topBar = {
            StockPriceTopBar(
                stock = stock,
                actionBack = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        },
        content = {
            StockPriceList(
                stockPrice = stockPrice,
                clickable = {

                },
                modifier = modifier.padding(it)
            )
        }
    )
}