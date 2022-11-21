package com.chukimmuoi.stockvn.presentation.screen.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.LogoButton
import com.chukimmuoi.core.designsystem.theme.StockVNTheme
import com.chukimmuoi.stockvn.presentation.components.annotation.ThemesPreviews

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
fun HomeTopBar(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface
        ),
        title = {
            Text(
                text = stringResource(R.string.home_label),
                fontWeight = FontWeight.Bold,
                modifier = modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            LogoButton {
                openDrawer()
            }
        }
    )
}

@ThemesPreviews
@Composable
fun HomeTopBarPreview() {
    StockVNTheme {
        HomeTopBar({})
    }
}
