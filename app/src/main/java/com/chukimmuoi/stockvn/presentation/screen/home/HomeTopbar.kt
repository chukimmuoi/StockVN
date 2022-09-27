package com.chukimmuoi.stockvn.presentation.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.LogoButton
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme

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
fun HomeTopBar(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        title = {
            Text(
                text = stringResource(R.string.home_label),
                fontWeight = FontWeight.Bold,
                modifier = modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5
            )
        },
        elevation = dimensionResource(
            id = R.dimen.elevation_of_top_bar
        ),
        navigationIcon = {
            LogoButton {
                openDrawer()
            }
        }
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
fun HomeTopBarPreview() {
    StockVNTheme {
        HomeTopBar({})
    }
}