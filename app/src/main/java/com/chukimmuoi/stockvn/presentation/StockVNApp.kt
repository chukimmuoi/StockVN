package com.chukimmuoi.stockvn.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chukimmuoi.core.designsystem.theme.StockVNTheme
import com.chukimmuoi.stockvn.presentation.navigation.AppDrawer
import com.chukimmuoi.stockvn.presentation.navigation.StockVNNavigationActions
import kotlinx.coroutines.launch

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
fun StockApp() {
    StockVNTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val coroutineScope = rememberCoroutineScope() // Open/Close Drawer

            val navController = rememberNavController()
            val navigationActions = remember(navController) {
                StockVNNavigationActions(navController) // Action choose item
            }
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route ?: Screen.Home.route // Get current item choose

            val drawerState = rememberDrawerState(DrawerValue.Closed) // State Open/Close of Drawer

            ModalNavigationDrawer(
                drawerContent = {
                    AppDrawer(
                        currentRoute = currentRoute,
                        navigateToHome = navigationActions.navigateToHome,
                        navigateToStock = navigationActions.navigateToStock,
                        closeDrawer = { coroutineScope.launch { drawerState.close() } },
                        modifier = Modifier
                            .statusBarsPadding() // Padding with status bar
                            .navigationBarsPadding()
                    )
                },
                drawerState = drawerState,
                gesturesEnabled = true,
            ) {
                NavGraph(
                    openDrawer = {
                        coroutineScope.launch { drawerState.open() }
                    },
                    navController = navController,
                    startDestination = Screen.Home.route
                )
            }
        }
    }
}