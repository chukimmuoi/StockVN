package com.chukimmuoi.core.designsystem

import android.os.Build
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import com.chukimmuoi.core.designsystem.theme.*
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 04/12/2022.
 */
/**
 * Tests [StockVNTheme] using different combinations of the theme mode parameters:
 * darkTheme, dynamicColor, and androidTheme.
 *
 * It verifies that the various composition locals — [MaterialTheme], [LocalGradientColors] and
 * [LocalBackgroundTheme] — have the expected values for a given theme mode, as specified by the
 * design system.
 */
class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun darkThemeFalse_dynamicColorFalse() {
        composeTestRule.setContent {
            StockVNTheme(
                useDarkTheme = false,
                useDynamicTheme = false,
                content = {
                    val colorScheme = LightColors
                    assertColorSchemesEqual(colorScheme, MaterialTheme.colorScheme)

                    val gradientColors = GradientColors()
                    assertEquals(gradientColors, LocalGradientColors.current)

                    val backgroundTheme = BackgroundTheme(
                        color = colorScheme.surface,
                        tonalElevation = 2.dp
                    )
                    assertEquals(backgroundTheme, LocalBackgroundTheme.current)
                }
            )
        }
    }

    @Test
    fun darkThemeTrue_dynamicColorFalse() {
        composeTestRule.setContent {
            StockVNTheme(
                useDarkTheme = true,
                useDynamicTheme = false
            ) {
                val colorScheme = DarkColors
                assertColorSchemesEqual(colorScheme, MaterialTheme.colorScheme)

                val gradientColors = GradientColors()
                assertEquals(gradientColors, LocalGradientColors.current)

                val backgroundTheme = BackgroundTheme(
                    color = colorScheme.surface,
                    tonalElevation = 2.dp
                )
                assertEquals(backgroundTheme, LocalBackgroundTheme.current)
            }
        }
    }

    @Test
    fun darkThemeFalse_dynamicColorTrue() {
        composeTestRule.setContent {
            StockVNTheme(
                useDarkTheme = false,
                useDynamicTheme = true
            ) {
                val colorScheme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    dynamicLightColorScheme(LocalContext.current)
                } else {
                    LightColors
                }
                assertColorSchemesEqual(colorScheme, MaterialTheme.colorScheme)

                val gradientColors = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    GradientColors()
                } else {
                    LightColors
                }
                assertEquals(gradientColors, LocalGradientColors.current)

                val backgroundTheme = BackgroundTheme(
                    color = colorScheme.surface,
                    tonalElevation = 2.dp
                )
                assertEquals(backgroundTheme, LocalBackgroundTheme.current)
            }
        }
    }

    @Test
    fun darkThemeTrue_dynamicColorTrue() {
        composeTestRule.setContent {
            StockVNTheme(
                useDarkTheme = true,
                useDynamicTheme = true
            ) {
                val colorScheme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    dynamicDarkColorScheme(LocalContext.current)
                } else {
                    DarkColors
                }
                assertColorSchemesEqual(colorScheme, MaterialTheme.colorScheme)

                val gradientColors = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    GradientColors()
                } else {
                    DarkColors
                }
                assertEquals(gradientColors, LocalGradientColors.current)

                val backgroundTheme = BackgroundTheme(
                    color = colorScheme.surface,
                    tonalElevation = 2.dp
                )
                assertEquals(backgroundTheme, LocalBackgroundTheme.current)
            }
        }
    }

    /**
     * Workaround for the fact that the Stock design system specify all color scheme values.
     */
    private fun assertColorSchemesEqual(
        expectedColorScheme: ColorScheme,
        actualColorScheme: ColorScheme
    ) {
        assertEquals(expectedColorScheme.primary, actualColorScheme.primary)
        assertEquals(expectedColorScheme.onPrimary, actualColorScheme.onPrimary)
        assertEquals(expectedColorScheme.primaryContainer, actualColorScheme.primaryContainer)
        assertEquals(expectedColorScheme.onPrimaryContainer, actualColorScheme.onPrimaryContainer)
        assertEquals(expectedColorScheme.secondary, actualColorScheme.secondary)
        assertEquals(expectedColorScheme.onSecondary, actualColorScheme.onSecondary)
        assertEquals(expectedColorScheme.secondaryContainer, actualColorScheme.secondaryContainer)
        assertEquals(
            expectedColorScheme.onSecondaryContainer,
            actualColorScheme.onSecondaryContainer
        )
        assertEquals(expectedColorScheme.tertiary, actualColorScheme.tertiary)
        assertEquals(expectedColorScheme.onTertiary, actualColorScheme.onTertiary)
        assertEquals(expectedColorScheme.tertiaryContainer, actualColorScheme.tertiaryContainer)
        assertEquals(expectedColorScheme.onTertiaryContainer, actualColorScheme.onTertiaryContainer)
        assertEquals(expectedColorScheme.error, actualColorScheme.error)
        assertEquals(expectedColorScheme.onError, actualColorScheme.onError)
        assertEquals(expectedColorScheme.errorContainer, actualColorScheme.errorContainer)
        assertEquals(expectedColorScheme.onErrorContainer, actualColorScheme.onErrorContainer)
        assertEquals(expectedColorScheme.background, actualColorScheme.background)
        assertEquals(expectedColorScheme.onBackground, actualColorScheme.onBackground)
        assertEquals(expectedColorScheme.surface, actualColorScheme.surface)
        assertEquals(expectedColorScheme.onSurface, actualColorScheme.onSurface)
        assertEquals(expectedColorScheme.surfaceVariant, actualColorScheme.surfaceVariant)
        assertEquals(expectedColorScheme.onSurfaceVariant, actualColorScheme.onSurfaceVariant)
        assertEquals(expectedColorScheme.outline, actualColorScheme.outline)
    }
}