package com.chukimmuoi.stockvn.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chukimmuoi.stockvn.presentation.screen.stock.StockScreen
import com.chukimmuoi.stockvn.presentation.screen.stock.StockViewModel
import com.chukimmuoi.stockvn.presentation.screen.stock.StockViewModelFactory

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 17/09/2022.
 */
@Composable
fun NavGraph(
    factory: StockViewModelFactory,
    stockViewModel: StockViewModel = viewModel(factory = factory),
    navController: NavHostController,
    startDestination: String = Screen.Home.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {

        }

        composable(Screen.Stock.route) {
            StockScreen(
                stockViewModel = stockViewModel,
                modifier = modifier
            )
        }

        composable(Screen.StockDetails.route) {

        }
    }
}