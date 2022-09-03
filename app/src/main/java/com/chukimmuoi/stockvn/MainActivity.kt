package com.chukimmuoi.stockvn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chukimmuoi.stockvn.ui.stock.StockViewModel
import com.chukimmuoi.stockvn.ui.stock.StockViewModelFactory
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: StockViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockVNTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(factory, "Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(
    factory: StockViewModelFactory,
    name: String,
    stockViewModel: StockViewModel = viewModel(factory = factory)
) {
    Text(text = "Hello $name!")
    stockViewModel.importFromCsv()
}