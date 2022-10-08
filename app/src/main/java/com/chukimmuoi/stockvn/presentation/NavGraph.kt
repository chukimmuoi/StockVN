package com.chukimmuoi.stockvn.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chukimmuoi.stockvn.presentation.screen.stockprice.StockPriceScreen
import com.chukimmuoi.stockvn.presentation.screen.home.HomeScreen
import com.chukimmuoi.stockvn.presentation.screen.stock.StockScreen

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
    openDrawer: () -> Unit = {},
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                openDrawer = openDrawer,
                navController = navController,
                modifier = modifier
            )
        }

        composable(
            Screen.Stock.route,
            arguments = listOf(
                navArgument(Screen.FLOOR) {
                    type = NavType.StringType
                    defaultValue = Screen.ALL_FLOOR_STOCK
                }
            )
        ) {
            it.arguments?.getString(Screen.FLOOR)?.let {
                StockScreen(
                    navController = navController,
                    floor = it,
                    modifier = modifier
                )
            }
        }

        composable(
            Screen.StockPrices.route,
            arguments = listOf(navArgument(Screen.CODE) { type = NavType.StringType })
        ) {
            it.arguments?.getString(Screen.CODE)?.let {
                StockPriceScreen(
                    stock = it,
                    navController = navController,
                    modifier = modifier
                )
            }
        }
    }
}