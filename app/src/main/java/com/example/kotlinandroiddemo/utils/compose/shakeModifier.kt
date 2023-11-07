package com.example.kotlinandroiddemo.utils.compose

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput


fun Modifier.shake() = composed(

    factory = {

        var buttonState by remember { mutableStateOf(false) }
        val transX by animateFloatAsState(
            targetValue = if (buttonState == true) -6.5f else 0f,
            animationSpec = repeatable(
                iterations = 7,
                animation = tween(durationMillis = 90, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )

        Modifier
            .graphicsLayer {
                translationX = transX
            }
            .pointerInput(buttonState) {
                awaitPointerEventScope {
                    buttonState = !buttonState
                }
            }


    }
)