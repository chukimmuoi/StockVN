package com.chukimmuoi.core.designsystem.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

/**
 * Stock filled button with generic content slot. Wraps Material 3 [Button].
 *
 * @param onClick Will be called when the user clicks the button.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be
 * clickable and will appear disabled to accessibility services.
 * @param small Whether or not the size of the button should be small or regular.
 * @param colors [ButtonColors] that will be used to resolve the container and content color for
 * this button in different states. See [StockButtonDefaults.filledButtonColors].
 * @param contentPadding The spacing values to apply internally between the container and the
 * content. See [StockButtonDefaults.buttonContentPadding].
 * @param content The button content.
 */
@Composable
fun StockFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    colors: ButtonColors = StockButtonDefaults.filledButtonColors(),
    contentPadding: PaddingValues = StockButtonDefaults.buttonContentPadding(small = small),
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = if (small) {
            modifier.heightIn(min = StockButtonDefaults.smallButtonHeight)
        } else {
            modifier
        },
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        content = {
            content()
        }
    )
}

/**
 * Stock filled button with text and icon content slots.
 *
 * @param onClick Will be called when the user clicks the button.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be
 * clickable and will appear disabled to accessibility services.
 * @param small Whether or not the size of the button should be small or regular.
 * @param colors [ButtonColors] that will be used to resolve the container and content color for
 * this button in different states. See [StockButtonDefaults.filledButtonColors].
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Pass `null` here for no leading icon.
 * @param trailingIcon The button trailing icon content. Pass `null` here for no trailing icon.
 */
@Composable
fun StockFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    colors: ButtonColors = StockButtonDefaults.filledButtonColors(),
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    StockFilledButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        small = small,
        colors = colors,
        contentPadding = StockButtonDefaults.buttonContentPadding(
            small = small,
            leadingIcon = leadingIcon != null,
            trailingIcon = trailingIcon != null
        ),
        content = {
            StockButtonContent(
                text = text,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon
            )
        }
    )
}

/**
 * Stock outlined button with generic content slot. Wraps Material 3 [OutlinedButton].
 *
 * @param onClick Will be called when the user clicks the button.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be
 * clickable and will appear disabled to accessibility services.
 * @param small Whether or not the size of the button should be small or regular.
 * @param border Border to draw around the button. Pass `null` here for no border.
 * @param colors [ButtonColors] that will be used to resolve the container and content color for
 * this button in different states. See [StockButtonDefaults.outlinedButtonColors].
 * @param contentPadding The spacing values to apply internally between the container and the
 * content. See [StockButtonDefaults.buttonContentPadding].
 * @param content The button content.
 */
@Composable
fun StockOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    border: BorderStroke? = StockButtonDefaults.outlinedButtonBorder(enabled = enabled),
    colors: ButtonColors = StockButtonDefaults.outlinedButtonColors(),
    contentPadding: PaddingValues = StockButtonDefaults.buttonContentPadding(small = small),
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = if (small) {
            modifier.heightIn(min = StockButtonDefaults.smallButtonHeight)
        } else {
            modifier
        },
        enabled = enabled,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
        content = {
            content()
        }
    )
}

/**
 * Stock outlined button with text and icon content slots.
 *
 * @param onClick Will be called when the user clicks the button.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be
 * clickable and will appear disabled to accessibility services.
 * @param small Whether or not the size of the button should be small or regular.
 * @param border Border to draw around the button. Pass `null` here for no border.
 * @param colors [ButtonColors] that will be used to resolve the container and content color for
 * this button in different states. See [StockButtonDefaults.outlinedButtonColors].
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Pass `null` here for no leading icon.
 * @param trailingIcon The button trailing icon content. Pass `null` here for no trailing icon.
 */
@Composable
fun StockOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    border: BorderStroke? = StockButtonDefaults.outlinedButtonBorder(enabled = enabled),
    colors: ButtonColors = StockButtonDefaults.outlinedButtonColors(),
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    StockOutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        small = small,
        border = border,
        colors = colors,
        contentPadding = StockButtonDefaults.buttonContentPadding(
            small = small,
            leadingIcon = leadingIcon != null,
            trailingIcon = trailingIcon != null
        ),
        content = {
            StockButtonContent(
                text = text,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon
            )
        }
    )
}

/**
 * Stock text button with generic content slot. Wraps Material 3 [TextButton].
 *
 * @param onClick Will be called when the user clicks the button.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be
 * clickable and will appear disabled to accessibility services.
 * @param small Whether or not the size of the button should be small or regular.
 * @param colors [ButtonColors] that will be used to resolve the container and content color for
 * this button in different states. See [StockButtonDefaults.textButtonColors].
 * @param contentPadding The spacing values to apply internally between the container and the
 * content. See [StockButtonDefaults.buttonContentPadding].
 * @param content The button content.
 */
@Composable
fun StockTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    colors: ButtonColors = StockButtonDefaults.textButtonColors(),
    contentPadding: PaddingValues = StockButtonDefaults.buttonContentPadding(small = small),
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = if (small) {
            modifier.heightIn(min = StockButtonDefaults.smallButtonHeight)
        } else {
            modifier
        },
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        content = {
            content()
        }
    )
}

/**
 * Stock text button with text and icon content slots.
 *
 * @param onClick Will be called when the user clicks the button.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be
 * clickable and will appear disabled to accessibility services.
 * @param small Whether or not the size of the button should be small or regular.
 * @param colors [ButtonColors] that will be used to resolve the container and content color for
 * this button in different states. See [StockButtonDefaults.textButtonColors].
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Pass `null` here for no leading icon.
 * @param trailingIcon The button trailing icon content. Pass `null` here for no trailing icon.
 */
@Composable
fun StockTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    small: Boolean = false,
    colors: ButtonColors = StockButtonDefaults.textButtonColors(),
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    StockTextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        small = small,
        colors = colors,
        contentPadding = StockButtonDefaults.buttonContentPadding(
            small = small,
            leadingIcon = leadingIcon != null,
            trailingIcon = trailingIcon != null
        ),
        content = {
            StockButtonContent(
                text = text,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon
            )
        }
    )
}

/**
 * Internal Stock button content layout for arranging the text label, leading icon and
 * trailing icon.
 *
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Pass `null` here for no leading icon.
 * @param trailingIcon The button trailing icon content. Pass `null` here for no trailing icon.
 */
@Composable
private fun StockButtonContent(
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?
) {
    ProvideTextStyle(value = MaterialTheme.typography.labelSmall) {
        if (leadingIcon != null) {
            Box(
                modifier = Modifier.sizeIn(maxHeight = StockButtonDefaults.buttonIconSize),
                content = {
                    leadingIcon()
                }
            )
        }

        Box(
            modifier = Modifier.padding(
                start = if (leadingIcon != null) {
                    StockButtonDefaults.buttonContentSpacing
                } else {
                    0.dp
                },
                end = if (trailingIcon != null) {
                    StockButtonDefaults.buttonContentSpacing
                } else {
                    0.dp
                }
            ),
            content = {
                text()
            }
        )

        if (trailingIcon != null) {
            Box(
                modifier = Modifier.sizeIn(maxHeight = StockButtonDefaults.buttonIconSize),
                content = {
                    trailingIcon()
                }
            )
        }
    }
}