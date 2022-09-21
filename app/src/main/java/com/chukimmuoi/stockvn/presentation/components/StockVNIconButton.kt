package com.chukimmuoi.stockvn.presentation.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.preview.StateValue
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme

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
fun LogoButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.Timeline,
            contentDescription = stringResource(id = R.string.logo_icon_content_description)
        )
    }
}

@Preview
@Composable
fun PreviewLogoButton() {
    StockVNTheme {
        LogoButton({})
    }
}

@Composable
fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_icon_content_description)
        )
    }
}

@Preview
@Composable
fun PreviewBackButton() {
    StockVNTheme {
        BackButton({})
    }
}

@Composable
fun SearchButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_icon_content_description)
        )
    }
}

@Preview
@Composable
fun PreviewSearchButton() {
    StockVNTheme {
        SearchButton({})
    }
}

@Composable
fun BookmarkButton(
    isBookmarked: Boolean,
    onClick: () -> Unit,
    contentAlpha: Float = ContentAlpha.high,
    modifier: Modifier = Modifier
) {
    val clickLabel = stringResource(
        if (isBookmarked) R.string.un_bookmark_label else R.string.bookmark_label
    )
    CompositionLocalProvider(LocalContentAlpha provides contentAlpha) {
        IconToggleButton(
            checked = isBookmarked,
            onCheckedChange = { onClick() },
            modifier = modifier.semantics {
                onClick(
                    label = clickLabel,
                    action = null
                )
            }
        ) {
            Icon(
                imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                contentDescription = stringResource(R.string.bookmark_icon_content_description)
            )
        }
    }
}

@Preview
@Composable
fun PreviewBookmarkButton(@PreviewParameter(StateValue::class) state: Boolean) {
    StockVNTheme {
        BookmarkButton(state, {})
    }
}

@Composable
fun StarButton(
    isStared: Boolean,
    onClick: () -> Unit,
    contentAlpha: Float = ContentAlpha.high,
    modifier: Modifier = Modifier
) {
    val clickLabel = stringResource(
        if (isStared) R.string.un_start_label else R.string.start_label
    )
    CompositionLocalProvider(LocalContentAlpha provides contentAlpha) {
        IconToggleButton(
            checked = isStared,
            onCheckedChange = { onClick() },
            modifier = modifier.semantics {
                onClick(
                    label = clickLabel,
                    action = null
                )
            }
        ) {
            Icon(
                imageVector = if (isStared) Icons.Filled.HotelClass else Icons.Filled.StarBorderPurple500,
                contentDescription = stringResource(R.string.star_icon_content_description)
            )
        }
    }
}

@Preview
@Composable
fun PreviewStartButton(@PreviewParameter(StateValue::class) state: Boolean) {
    StockVNTheme {
        StarButton(state, {})
    }
}