package com.chukimmuoi.core.designsystem.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 27/11/2022.
 */
object StockButtonDefaults {

    val smallButtonHeight: Dp = 32.dp

    const val disabledButtonContainerAlpha: Float = 0.12F
    const val disabledButtonContentAlpha: Float = 0.38F

    val buttonHorizontalPadding: Dp = 24.dp
    val buttonHorizontalIconPadding: Dp = 16.dp
    val buttonVerticalPadding: Dp = 8.dp

    val smallButtonHorizontalPadding: Dp = 16.dp
    val smallButtonHorizontalIconPadding: Dp = 12.dp
    val smallButtonVerticalPadding: Dp = 6.dp

    val buttonContentSpacing: Dp = 8.dp
    val buttonIconSize: Dp = 18.dp

    fun buttonContentPadding(
        small: Boolean,
        leadingIcon: Boolean = false,
        trailingIcon: Boolean = false
    ): PaddingValues {

        return PaddingValues(
            start = when {
                small && leadingIcon -> smallButtonHorizontalIconPadding
                small -> smallButtonHorizontalPadding
                leadingIcon -> buttonHorizontalIconPadding
                else -> buttonHorizontalPadding
            },
            top = if (small) smallButtonVerticalPadding else buttonVerticalPadding,
            end = when {
                small && trailingIcon -> smallButtonHorizontalIconPadding
                small -> smallButtonHorizontalPadding
                trailingIcon -> buttonHorizontalIconPadding
                else -> buttonHorizontalPadding
            },
            bottom = if (small) smallButtonVerticalPadding else buttonVerticalPadding
        )
    }

    @Composable
    fun filledButtonColors(
        containerColor: Color = MaterialTheme.colorScheme.onBackground,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = disabledButtonContainerAlpha
        ),
        disabledContentColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = disabledButtonContentAlpha
        )
    ): ButtonColors {

        return ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )
    }

    @Composable
    fun outlinedButtonBorder(
        enabled: Boolean,
        width: Dp = 1.dp,
        color: Color = MaterialTheme.colorScheme.onBackground,
        disabledColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = disabledButtonContainerAlpha
        )
    ): BorderStroke {

        return BorderStroke(
            width = width,
            color = if (enabled) color else disabledColor
        )
    }

    @Composable
    fun outlinedButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        disabledContainerColor: Color = Color.Transparent,
        disabledContentColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = disabledButtonContentAlpha
        )
    ): ButtonColors {

        return ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )
    }

    @Composable
    fun textButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = MaterialTheme.colorScheme.onBackground,
        disabledContainerColor: Color = Color.Transparent,
        disabledContentColor: Color = MaterialTheme.colorScheme.onBackground.copy(
            alpha = disabledButtonContentAlpha
        )
    ): ButtonColors {

        return ButtonDefaults.textButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        )
    }
}