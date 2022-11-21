package com.chukimmuoi.stockvn.presentation.navigation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.preview.ValueBooleanProvider
import com.chukimmuoi.core.designsystem.theme.StockVNTheme

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 18/09/2022.
 */

/**
 * Create icon for app
 *
 * @param tintColor Color set for image
 * @param modifier
 * */
@Composable
fun StockVNIcon(
    tintColor: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier
) {
    Image(
        imageVector = Icons.Filled.Timeline, // Set image
        contentDescription = stringResource(id = R.string.timeline_icon_content_description),
        colorFilter = ColorFilter.tint(tintColor), // Set color for image
        modifier = modifier.size(48.dp),

    )
}

@Preview("StockVN icon")
@Preview("StockVN icon (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewJetNewsIcon() {
    StockVNTheme {
        Surface {
            StockVNIcon()
        }
    }
}

/**
 * Create icon use in Navigation
 *
 * @param icon Image vector of icon
 * @param isSelected Is choose or not
 * @param contentDescription Description of icon
 * @param tintColor Set color for image
 * @param modifier
 * */
@Composable
fun NavigationIcon(
    icon: ImageVector,
    isSelected: Boolean,
    contentDescription: String? = null,
    tintColor: Color? = null,
    modifier: Modifier = Modifier,
) {
    val imageAlpha = if (isSelected) {
        1F
    } else {
        0.6F
    }

    val iconTintColor = tintColor ?: if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurface.copy(alpha = imageAlpha)
    }

    Image(
        modifier = modifier,
        imageVector = icon,
        contentDescription = contentDescription,
        contentScale = ContentScale.Inside,
        colorFilter = ColorFilter.tint(iconTintColor),
        alpha = imageAlpha
    )
}

@Preview("Navigation icon")
@Preview("Navigation (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNavigationIcon(
    @PreviewParameter(ValueBooleanProvider::class) state: Boolean
) {
    StockVNTheme {
        Surface {
            NavigationIcon(
                icon = Icons.Filled.Home,
                isSelected = state
            )
        }
    }
}