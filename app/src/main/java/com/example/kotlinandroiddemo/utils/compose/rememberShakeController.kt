package com.example.kotlinandroiddemo.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kotlinandroiddemo.model.ShakeConfig

@Composable
fun rememberShakeController(): ShakeController {
    return remember { ShakeController() }
}

class ShakeController {
    var shakeConfig: ShakeConfig? by mutableStateOf(null)
        private set

    fun shake(shakeConfig: ShakeConfig) {
        this.shakeConfig = shakeConfig
    }
}