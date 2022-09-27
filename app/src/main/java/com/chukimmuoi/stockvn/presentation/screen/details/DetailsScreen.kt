package com.chukimmuoi.stockvn.presentation.screen.details

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.chukimmuoi.stockvn.ui.theme.appContentColor
import com.chukimmuoi.stockvn.ui.theme.appThemeColor
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
@Composable
fun DetailsScreen(
    stock: String,
    navController: NavController,
    viewModel: DetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {

    viewModel.code = stock
    val dateStockInfo = viewModel.selectedDateStockInfoPage.collectAsLazyPagingItems()

    Scaffold(
        backgroundColor = MaterialTheme.colors.appThemeColor,
        contentColor = MaterialTheme.colors.appContentColor,
        topBar = {
            DetailTopBar(
                stock = stock,
                actionBack = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        },
        content = {
            DetailsList(
                dateStockInfo = dateStockInfo,
                clickable = {

                }
            )
        }
    )
}