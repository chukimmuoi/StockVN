package com.chukimmuoi.stockvn.presentation.screen.stock

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.BackButton
import com.chukimmuoi.stockvn.presentation.components.SearchButton
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme

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
fun StockTopBar(
    actionBack: () -> Unit,
    actionSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        title = {
            Text(
                text = stringResource(R.string.stock_screen_title),
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
        actions = {
            SearchButton {
                actionSearch("")
            }
        },
    )
}

@Preview(
    name = "UI_MODE_NIGHT_YES",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "UI_MODE_NIGHT_NO",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun StockTopBarPreview() {
    StockVNTheme {
        StockTopBar(
            actionBack = {

            },
            actionSearch = {

            }
        )
    }
}