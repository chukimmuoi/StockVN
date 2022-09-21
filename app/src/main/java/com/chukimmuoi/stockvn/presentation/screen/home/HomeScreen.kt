package com.chukimmuoi.stockvn.presentation.screen.home

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    modifier: Modifier = Modifier
) {
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

        }
    )
}