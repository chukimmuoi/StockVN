package com.chukimmuoi.core.designsystem.component

import androidx.compose.animation.VectorConverter
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 26/11/2022.
 */
/**
 * See more
 * @link{https://medium.com/androiddevelopers/custom-canvas-animations-in-jetpack-compose-e7767e349339}
 * Easing: @link{https://medium.com/androiddevelopers/easing-in-to-easing-curves-in-jetpack-compose-d72893eeeb4d}
 * https://cubic-bezier.com/
 * https://www.youtube.com/watch?v=aVwxzDHniEw
 * https://easings.net/
 * https://github.com/sephiroth74/Android-Easing
 * and from MUOICK: https://github.com/chukimmuoi/FacebookReaction
 */
@Preview
@Composable
fun CustomCanvasAnimation() {
    val angleFrom = 0F
    val angleTo = 360F
    val angle = remember {
        Animatable(angleFrom)
    }

    val colorFrom = Color.Green
    val colorTo = Color.Blue
    val color = remember {
        Animatable(
            initialValue = colorFrom,
            typeConverter = Color.VectorConverter(ColorSpaces.LinearSrgb)
        )
    }

    val animationDuration = 3_000
    val easingDefault = EaseOutBounce
    LaunchedEffect(angle, color) {
        launch {
            angle.animateTo(
                targetValue = angleTo,
                animationSpec = tween(
                    animationDuration,
                    easing = easingDefault
                )
            )
        }
        launch {
            color.animateTo(
                targetValue = colorTo,
                animationSpec = tween(
                    animationDuration,
                    easing = easingDefault
                )
            )
        }
    }

    val sizeDefault = 192.dp
    val radiusDefault = 16.dp
    Canvas(
        modifier = Modifier.size(sizeDefault),
        onDraw = {
            rotate(angle.value) {
                drawRoundRect(
                    color = color.value,
                    cornerRadius = CornerRadius(radiusDefault.toPx())
                )
            }
        }
    )
}