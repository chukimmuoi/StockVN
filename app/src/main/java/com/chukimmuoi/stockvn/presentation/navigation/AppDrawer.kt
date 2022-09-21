package com.chukimmuoi.stockvn.presentation.navigation

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.Screen

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 18/09/2022.
 */
@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToStock: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        StockVNLogo(
            modifier = modifier.padding(
                dimensionResource(
                    id = R.dimen.padding_content_of_navigation
                )
            )
        )
        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = .2f))
        DrawerItem(
            icon = Icons.Filled.Home,
            label = stringResource(id = R.string.home_label),
            isSelected = currentRoute == Screen.Home.route,
            action = {
                navigateToHome()
                closeDrawer()
            }
        )
        DrawerItem(
            icon = Icons.Filled.Timeline,
            label = stringResource(id = R.string.stock_label),
            isSelected = currentRoute == Screen.Stock.route,
            action = {
                navigateToStock()
                closeDrawer()
            }
        )
    }
}

/**
 * Show logo and app name
 * */
@Composable
private fun StockVNLogo(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        StockVNIcon()
        Spacer(
            modifier = modifier.width(
                dimensionResource(
                    id = R.dimen.padding_content_of_navigation
                )
            )
        )
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onSurface // Color.Black
        )
    }
}

/**
 * Drawer item navigation
 *
 * @param icon Icon of item
 * @param label Label of item
 * @param isSelected is choose
 * @param action ic click choose
 * @param modifier
 * */
@Composable
private fun DrawerItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colors
    val textIconColor = if (isSelected) {
        colors.primary
    } else {
        colors.onSurface.copy(alpha = 0.6f)
    }
    val backgroundColor = if (isSelected) {
        colors.primary.copy(alpha = 0.12f)
    } else {
        Color.Transparent
    }

    val padding = dimensionResource(id = R.dimen.padding_content_of_navigation)
    val surfaceModifier = modifier
        .padding(
            start = padding,
            top = padding,
            end = padding
        )
        .fillMaxWidth()

    Surface(
        modifier = surfaceModifier,
        color = backgroundColor,
        shape = MaterialTheme.shapes.small,
    ) {
        TextButton(
            onClick = action,
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                NavigationIcon(
                    icon = icon,
                    isSelected = isSelected,
                    contentDescription = null,
                    tintColor = textIconColor
                )
                Spacer(
                    modifier.width(
                        dimensionResource(
                            id = R.dimen.margin_item_of_navigation
                        )
                    )
                )
                Text(
                    text = label,
                    style = MaterialTheme.typography.body2,
                    color = textIconColor
                )
            }
        }
    }
}

@Preview("Drawer contents")
@Preview("Drawer contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppDrawer() {
    StockVNTheme {
        Surface {
            AppDrawer(
                currentRoute = Screen.Home.route,
                navigateToHome = {},
                navigateToStock = {},
                closeDrawer = {}
            )
        }
    }
}