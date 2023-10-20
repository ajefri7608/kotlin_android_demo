package com.example.kotlinandroiddemo.utils.compose

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import com.example.kotlinandroiddemo.utils.ShakeController


fun Modifier.shake(shakeController: ShakeController) = composed(

    factory = {
        shakeController.shakeConfig?.let { shakeConfig ->
            val shake = remember { Animatable(0f) }
            LaunchedEffect(shakeController.shakeConfig) {
                for (i in 0..shakeConfig.iterations) {
                    when (i % 2) {
                        0 -> shake.animateTo(1f, tween(durationMillis = 65))
                        else -> shake.animateTo(-1f, tween(durationMillis = 65))
                    }
                }
                shake.animateTo(0f)
            }
            Modifier
                .graphicsLayer {
                    translationX = shake.value * shakeConfig.translateX
                }

        } ?: this
    }
)