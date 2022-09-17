package com.chukimmuoi.stockvn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chukimmuoi.stockvn.presentation.navigation.NavGraph
import com.chukimmuoi.stockvn.presentation.navigation.Screen
import com.chukimmuoi.stockvn.presentation.screen.stock.StockViewModelFactory
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @Inject lateinit var factory: StockViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockVNTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navController = rememberNavController()
                    NavGraph(
                        factory = factory,
                        navController = navController,
                        startDestination = Screen.Stock.route
                    )
                }
            }
        }
    }
}