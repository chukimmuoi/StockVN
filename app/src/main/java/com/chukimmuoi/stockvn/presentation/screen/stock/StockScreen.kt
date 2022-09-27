package com.chukimmuoi.stockvn.presentation.screen.stock

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
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
 * Created by chukimmuoi on 04/09/2022.
 */
@Composable
fun StockScreen(
    viewModel: StockViewModel = hiltViewModel(),
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val stocks = viewModel.allStock.collectAsLazyPagingItems()

    Scaffold(
        backgroundColor = MaterialTheme.colors.appThemeColor,
        contentColor = MaterialTheme.colors.appContentColor,
        topBar = {
            StockTopBar(
                actionBack = {
                    navController.popBackStack()
                },
                actionSearch = {

                },
                modifier = modifier
            )
        },
        content = {
            StockList(
                stocks = stocks,
                clickable = {
                    navController.navigate(route = Screen.StockDetails.passStockCode(it.code))
                }
            )
        }
    )
}