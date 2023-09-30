package com.example.kotlinandroiddemo.model

import androidx.annotation.StringRes
import com.example.kotlinandroiddemo.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object HomeScreen : Screen("homeScreen", R.string.homeScreen)
    object LoginScreen : Screen("loginScreen", R.string.loginScreen)
}