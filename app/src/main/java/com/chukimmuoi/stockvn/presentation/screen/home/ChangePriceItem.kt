package com.chukimmuoi.stockvn.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.UnfoldMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.chukimmuoi.data.model.ChangePrice
import com.chukimmuoi.stockvn.R
import com.chukimmuoi.stockvn.presentation.components.annotation.ThemesPreviews
import com.chukimmuoi.stockvn.presentation.components.preview.ChangePriceProvider
import com.chukimmuoi.stockvn.ui.theme.StockVNTheme

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 05/10/2022.
 */
@Composable
fun ChangePriceItem(
    changePrice: ChangePrice,
    clickableGoTo: (ChangePrice) -> Unit,
    modifier: Modifier = Modifier
) {
    val stateIcon = changePrice.handlerSateIcon(
        upAction = {
            Icons.Filled.ArrowDropUp
        },
        downAction = {
            Icons.Filled.ArrowDropDown
        },
        unchanged = {
            Icons.Filled.UnfoldMore
        }
    )
    val stateColor = changePrice.handlerSateColor()

    Card(
        elevation = dimensionResource(
            id = R.dimen.elevation_of_card_item
        ),
        modifier = modifier.clickable {
            clickableGoTo(changePrice)
        }
    ) {
        Column(
            modifier = modifier.padding(
                dimensionResource(
                    id = R.dimen.padding_content_of_card_item
                )
            ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = changePrice.code,
                color = stateColor,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = changePrice.priceDisplay(),
                color = stateColor,
                fontWeight = FontWeight.Bold
            )
            Row {
                Row(
                    modifier = modifier.weight(0.5F)
                ) {
                    Image(
                        imageVector = stateIcon,
                        colorFilter = ColorFilter.tint(stateColor),
                        contentDescription = "State Icon"
                    )
                    Text(
                        text = changePrice.changeDisplay(),
                        color = stateColor,
                        textAlign = TextAlign.Center
                    )
                }
                Text(
                    text = changePrice.changePercentDisplay(),
                    color = stateColor,
                    modifier = modifier.weight(0.5F),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@ThemesPreviews
@Composable
fun ChangePriceItemPreview(@PreviewParameter(ChangePriceProvider::class) changePrice: ChangePrice) {
    StockVNTheme {
        ChangePriceItem(
            changePrice = changePrice,
            clickableGoTo = {}
        )
    }
}