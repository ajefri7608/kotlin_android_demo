package com.example.kotlinandroiddemo.model

import androidx.compose.runtime.Composable

data class BottomSheetState(
    var content: @Composable () -> Unit = {},
    val isOpening: Boolean = true
) {

}