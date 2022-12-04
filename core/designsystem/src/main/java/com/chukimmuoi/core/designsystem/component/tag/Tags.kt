package com.chukimmuoi.core.designsystem.component.tag

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.chukimmuoi.core.designsystem.R
import com.chukimmuoi.core.designsystem.component.button.StockButtonDefaults
import com.chukimmuoi.core.designsystem.component.button.StockTextButton
import com.chukimmuoi.core.designsystem.component.menu.StockDropdownMenu

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 04/12/2022.
 */
@Composable
fun StockTopicTag(
    expanded: Boolean = false,
    followed: Boolean,
    onDropMenuToggle: (show: Boolean) -> Unit = {},
    onFollowClick: () -> Unit,
    onUnfollowClick: () -> Unit,
    onBrowseClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    followText: @Composable () -> Unit = { Text(stringResource(R.string.follow)) },
    unFollowText: @Composable () -> Unit = { Text(stringResource(R.string.unfollow)) },
    browseText: @Composable () -> Unit = { Text(stringResource(R.string.browse_topic)) }
) {

    Box(modifier = modifier) {
        val containerColor = if (followed) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surfaceVariant
        }
        StockTextButton(
            onClick = { onDropMenuToggle(true) },
            enabled = enabled,
            small = true,
            colors = StockButtonDefaults.textButtonColors(
                containerColor = containerColor,
                contentColor = contentColorFor(backgroundColor = containerColor),
                disabledContainerColor = if (followed) {
                    MaterialTheme.colorScheme.onBackground.copy(
                        alpha = StockButtonDefaults.disabledButtonContentAlpha
                    )
                } else {
                    Color.Transparent
                }
            ),
            text = text
        )
        StockDropdownMenu(
            expanded = expanded,
            onDismissRequest = { onDropMenuToggle(false) },
            items = if (followed) listOf(UNFOLLOW, BROWSE) else listOf(FOLLOW, BROWSE),
            onItemClick = { item ->
                when (item) {
                    FOLLOW -> onFollowClick()
                    UNFOLLOW -> onUnfollowClick()
                    BROWSE -> onBrowseClick()
                }
            },
            itemText = { item ->
                when (item) {
                    FOLLOW -> followText()
                    UNFOLLOW -> unFollowText()
                    BROWSE -> browseText()
                }
            }
        )
    }
}

private const val FOLLOW = 1
private const val UNFOLLOW = 2
private const val BROWSE = 3