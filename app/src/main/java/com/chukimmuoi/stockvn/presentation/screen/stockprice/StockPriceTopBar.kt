package com.chukimmuoi.stockvn.presentation.screen.stockprice

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.BackButton

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
fun StockPriceTopBar(
    stock: String,
    actionBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        title = {
            Text(
                text = stock,
                fontWeight = FontWeight.Bold,
                modifier = modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5
            )
        },
        elevation = dimensionResource(
            id = R.dimen.elevation_of_top_bar
        ),
        navigationIcon = {
            BackButton {
                actionBack()
            }
        },
    )
}