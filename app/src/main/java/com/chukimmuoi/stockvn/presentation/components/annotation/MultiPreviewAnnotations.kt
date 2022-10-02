package com.chukimmuoi.stockvn.presentation.components.annotation

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 01/10/2022.
 */
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.Preview

/**
 * Add this multipreview annotation to a composable to render the composable in extra small and
 * extra large font size.
 *
 * Read more in the [documentation](https://d.android.com/jetpack/compose/tooling#preview-multipreview)
 */
@Preview(
    name = "small font",
    group = "font scales",
    fontScale = 0.5f
)
@Preview(
    name = "large font",
    group = "font scales",
    fontScale = 1.5f
)
annotation class FontScalePreviews

/**
 * Add this multipreview annotation to a composable to render the composable on various device
 * sizes: phone, foldable, and tablet.
 *
 * Read more in the [documentation](https://d.android.com/jetpack/compose/tooling#preview-multipreview)
 */
@Preview(
    name = "phone",
    group = "devices",
    device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480"
)
@Preview(
    name = "foldable",
    group = "devices",
    device = "spec:shape=Normal,width=673,height=841,unit=dp,dpi=480"
)
@Preview(
    name = "tablet",
    group = "devices",
    device = "spec:shape=Normal,width=1280,height=800,unit=dp,dpi=480"
)
annotation class DevicePreviews

/**
 * Add this multipreview annotation to a composable to render the composable in various common
 * configurations:
 * - Dark theme
 * - Small and large font size
 * - various device sizes
 *
 * Read more in the [documentation](https://d.android.com/jetpack/compose/tooling#preview-multipreview)
 *
 * _Note: Combining multipreview annotations doesn't mean all the different combinations are shown.
 * Instead, each multipreview annotation acts by its own and renders only its own variants._
 */
@Preview(
    name = "dark theme",
    group = "themes",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(
    name = "light theme",
    group = "themes",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
annotation class ThemesPreviews

@ThemesPreviews
@FontScalePreviews
@DevicePreviews
annotation class CompletePreviews