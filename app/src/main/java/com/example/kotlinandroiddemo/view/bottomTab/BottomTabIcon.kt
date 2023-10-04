package com.example.kotlinandroiddemo.view.bottomTab


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun BottomTabIcon(icon: Int, selected: Boolean) {
    Image(
        painter = painterResource(id = icon),
        modifier = Modifier
            .size(21.dp),
        contentDescription = null,
        colorFilter = ColorFilter.tint(
            if (selected == true) Color("#00c090".toColorInt()) else Color("#748c94".toColorInt())
        )
    )
}