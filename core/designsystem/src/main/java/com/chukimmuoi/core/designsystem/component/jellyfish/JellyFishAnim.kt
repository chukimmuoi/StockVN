package com.chukimmuoi.core.designsystem.component.jellyfish

import android.graphics.RuntimeShader
import android.os.Build
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
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Language

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

    val time by produceState(0f) {
        while (true) {
            withInfiniteAnimationFrameMillis {
                value = it.toFloat() / 1000f
            }
        }
    }

    val shader = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        RuntimeShader(PERLIN_NOISE)
    } else {
        null
    }

    Image(
        vectorPainter, contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .background(largeRadialGradient)
            .onSizeChanged { size ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    shader?.setFloatUniform(
                        "resolution",
                        size.width.toFloat(),
                        size.height.toFloat()
                    )
                }
            }
            .graphicsLayer {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    shader?.let {
                        it.setFloatUniform("time", time)

                        renderEffect = android.graphics.RenderEffect
                            .createRuntimeShaderEffect(
                                it,
                                "contents"
                            )
                            .asComposeRenderEffect()
                    }
                }
            }
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

@Language("AGSL")
val PERLIN_NOISE = """
    uniform float2 resolution;
    uniform float time;
    uniform shader contents; 
    
    //
    // Description : Array and textureless GLSL 2D/3D/4D simplex 
    //               noise functions.
    //      Author : Ian McEwan, Ashima Arts.
    //  Maintainer : stegu
    //     Lastmod : 20201014 (stegu)
    //     License : Copyright (C) 2011 Ashima Arts. All rights reserved.
    //               Distributed under the MIT License. See LICENSE file.
    //               https://github.com/ashima/webgl-noise
    //               https://github.com/stegu/webgl-noise
    // 
    
    vec3 mod289(vec3 x) {
      return x - floor(x * (1.0 / 289.0)) * 289.0;
    }
    
    vec4 mod289(vec4 x) {
      return x - floor(x * (1.0 / 289.0)) * 289.0;
    }
    
    vec4 permute(vec4 x) {
         return mod289(((x*34.0)+10.0)*x);
    }
    
    float snoise(vec3 v)
    { 
      const vec2  C = vec2(1.0/6.0, 1.0/3.0) ;
      const vec4  D = vec4(0.0, 0.5, 1.0, 2.0);
    
       // First corner
      vec3 i  = floor(v + dot(v, C.yyy) );
      vec3 x0 =   v - i + dot(i, C.xxx) ;
    
      // Other corners
      vec3 g = step(x0.yzx, x0.xyz);
      vec3 l = 1.0 - g;
      vec3 i1 = min( g.xyz, l.zxy );
      vec3 i2 = max( g.xyz, l.zxy );
    
      //   x0 = x0 - 0.0 + 0.0 * C.xxx;
      //   x1 = x0 - i1  + 1.0 * C.xxx;
      //   x2 = x0 - i2  + 2.0 * C.xxx;
      //   x3 = x0 - 1.0 + 3.0 * C.xxx;
      vec3 x1 = x0 - i1 + C.xxx;
      vec3 x2 = x0 - i2 + C.yyy; // 2.0*C.x = 1/3 = C.y
      vec3 x3 = x0 - D.yyy;      // -1.0+3.0*C.x = -0.5 = -D.y
    
      // Permutations
      i = mod289(i); 
      vec4 p = permute( permute( permute( 
                 i.z + vec4(0.0, i1.z, i2.z, 1.0 ))
               + i.y + vec4(0.0, i1.y, i2.y, 1.0 )) 
               + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));
    
      // Gradients: 7x7 points over a square, mapped onto an octahedron.
      // The ring size 17*17 = 289 is close to a multiple of 49 (49*6 = 294)
      float n_ = 0.142857142857; // 1.0/7.0
      vec3  ns = n_ * D.wyz - D.xzx;
    
      vec4 j = p - 49.0 * floor(p * ns.z * ns.z);  //  mod(p,7*7)
    
      vec4 x_ = floor(j * ns.z);
      vec4 y_ = floor(j - 7.0 * x_ );    // mod(j,N)
    
      vec4 x = x_ *ns.x + ns.yyyy;
      vec4 y = y_ *ns.x + ns.yyyy;
      vec4 h = 1.0 - abs(x) - abs(y);
    
      vec4 b0 = vec4( x.xy, y.xy );
      vec4 b1 = vec4( x.zw, y.zw );
    
      vec4 s0 = floor(b0)*2.0 + 1.0;
      vec4 s1 = floor(b1)*2.0 + 1.0;
      vec4 sh = -step(h, vec4(0.0));
    
      vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;
      vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;
    
      vec3 p0 = vec3(a0.xy,h.x);
      vec3 p1 = vec3(a0.zw,h.y);
      vec3 p2 = vec3(a1.xy,h.z);
      vec3 p3 = vec3(a1.zw,h.w);
    
      //Normalise gradients
      vec4 norm = inversesqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));
      p0 *= norm.x;
      p1 *= norm.y;
      p2 *= norm.z;
      p3 *= norm.w;
    
      // Mix final noise value
      vec4 m = max(0.5 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);
      m = m * m;
      return 105.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1), 
                                    dot(p2,x2), dot(p3,x3) ) );
    }
    
    half4 main(in vec2 fragCoord) {
        vec2 uv = (fragCoord.xy / resolution.xy);
        float noise = snoise(vec3(uv.x * 6, uv.y * 6, time * 0.5));
        
        noise *= exp(-length(abs(uv * 1.5)));	
        vec2 offset1 = vec2(noise * 0.02);
        vec2 offset2 = vec2(0.02) / resolution.xy;
        uv += offset1 - offset2;
        
        return contents.eval(uv * resolution.xy);
    }
""".trimIndent()