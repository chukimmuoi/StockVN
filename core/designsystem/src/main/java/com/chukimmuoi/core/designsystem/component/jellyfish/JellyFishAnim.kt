package com.chukimmuoi.core.designsystem.component.jellyfish

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.Group
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 23/11/2022.
 */
/**
 * See more: https://medium.com/androiddevelopers/making-jellyfish-move-in-compose-animating-imagevectors-and-applying-agsl-rendereffects-3666596a8888
 * Copyright from: https://gist.github.com/riggaroo/b139b0dfbf1fee932862dc52d1b08950
 * */
val solidWhite = SolidColor(Color.White)

@Preview
@Composable
fun JellyfishAnimation() {

    val blinkAlphaAnimation = remember {
        Animatable(1f)
    }
    val blinkScaleAnimation = remember {
        Animatable(1f)
    }

    suspend fun instantBlinkAnimation() {
        val tweenSpec = tween<Float>(150, easing = LinearEasing)
        coroutineScope {
            launch {
                blinkAlphaAnimation.animateTo(0f, animationSpec = tweenSpec)
                blinkAlphaAnimation.animateTo(1f, animationSpec = tweenSpec)
            }
            launch {
                blinkScaleAnimation.animateTo(0.3f, animationSpec = tweenSpec)
                blinkScaleAnimation.animateTo(1f, animationSpec = tweenSpec)
            }
        }
    }

    val duration = 3_000
    val transition = rememberInfiniteTransition()
    val translationY by transition.animateFloat(
        initialValue = 0f,
        targetValue = -30f,
        animationSpec = infiniteRepeatable(
            tween(duration, easing = EaseInOut),
            repeatMode = RepeatMode.Reverse
        )
    )

    val vectorPainterFace = rememberVectorPainter(
        defaultWidth = 530.46f.dp,
        defaultHeight = 563.1f.dp,
        viewportWidth = 530.46f,
        viewportHeight = 563.1f,
        autoMirror = true,
    ) { _, _ ->

        Group(name = "bubbles") {
            Path(
                JellyFishPaths.bubble1,
                fill = solidWhite,
                fillAlpha = 0.67f
            )

            Path(
                JellyFishPaths.bubble2,
                fill = solidWhite,
                fillAlpha = 0.75f
            )

            Path(
                JellyFishPaths.bubble3,
                fill = solidWhite,
                fillAlpha = 0.89f
            )

            Path(
                JellyFishPaths.bubble4,
                fill = solidWhite,
                fillAlpha = 0.77f
            )

            Path(
                JellyFishPaths.bubble5,
                fill = solidWhite,
                fillAlpha = 0.77f
            )
        }
        Group(name = "face", translationY = translationY) {
            Group(
                name = "eye-left",
                scaleY = blinkScaleAnimation.value,
                pivotY = 233f
            ) {
                Path(
                    JellyFishPaths.leftEye,
                    fill = SolidColor(Color(0xFFb4bebf)),
                    fillAlpha = blinkAlphaAnimation.value
                )
            }
            Group(
                name = "eye-right",
                scaleY = blinkScaleAnimation.value,
                pivotY = 233f
            ) {
                Path(
                    JellyFishPaths.rightEye,
                    fill = SolidColor(Color(0xFFb4bebf)),
                    fillAlpha = blinkAlphaAnimation.value
                )
            }

            Path(
                JellyFishPaths.mouth,
                fill = SolidColor(Color(0xFFd3d3d3)),
                fillAlpha = 0.72f
            )
        }
    }

    val vectorPainter = rememberVectorPainter(
        defaultWidth = 530.46f.dp,
        defaultHeight = 563.1f.dp,
        viewportHeight = 563.1f,
        viewportWidth = 530.46f,
        autoMirror = true,
    ) { _, _ ->

        Group(name = "jellyfish", translationY = translationY) {
            Group(name = "tentacles") {
                Path(
                    pathData = JellyFishPaths.tentaclePath,
                    fill = solidWhite,
                    fillAlpha = 0.49f
                )
                Path(
                    JellyFishPaths.tentacle2,
                    fill = solidWhite,
                    fillAlpha = 0.66f
                )
                Path(
                    JellyFishPaths.tentacle3,
                    fill = solidWhite,
                    fillAlpha = 0.45f
                )
                Path(
                    JellyFishPaths.tentacle4,
                    fill = solidWhite,
                    fillAlpha = 0.6f
                )
                Path(
                    JellyFishPaths.tentacle5,
                    fill = solidWhite,
                    fillAlpha = 1f
                )
                Path(
                    JellyFishPaths.tentacle6,
                    fill = solidWhite,
                    fillAlpha = 1f
                )
                Path(
                    JellyFishPaths.tentacle7,
                    fill = solidWhite,
                    fillAlpha = 1f
                )
                Path(
                    JellyFishPaths.tentacle8,
                    fill = solidWhite,
                    fillAlpha = 1f
                )
                Path(
                    JellyFishPaths.tentacle9,
                    fill = solidWhite
                )
            }
            Group(name = "body") {
                Path(
                    JellyFishPaths.face,
                    fill = solidWhite
                )
                Path(
                    JellyFishPaths.outerJelly,
                    fill = solidWhite,
                    fillAlpha = 0.5f
                )
            }
            Group(name = "freckles") {
                Path(
                    JellyFishPaths.freckle1,
                    fill = SolidColor(Color(0xfff0dfe2)),
                )
                Path(
                    JellyFishPaths.freckle2,
                    fill = SolidColor(Color(0xfff0dfe2)),
                )
                Path(
                    JellyFishPaths.freckle3,
                    fill = SolidColor(Color(0xfff0dfe2)),
                )
                Path(
                    JellyFishPaths.freckle4,
                    fill = SolidColor(Color(0xfff0dfe2)),
                )
            }
        }
    }

    Image(
        vectorPainter, contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .background(largeRadialGradient)
    )

    val coroutineScope = rememberCoroutineScope()
    Image(
        vectorPainterFace,
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    coroutineScope.launch {
                        instantBlinkAnimation()
                    }
                }
            }
    )
}

val largeRadialGradient = object : ShaderBrush() {

    override fun createShader(size: Size): Shader {
        val biggerDimension = maxOf(size.height, size.width)

        return RadialGradientShader(
            colors = listOf(
                Color(0xFF2be4dc),
                Color(0xFF243484)
            ),
            center = size.center,
            radius = biggerDimension / 2f,
            colorStops = listOf(0f, 0.95f)
        )
    }
}