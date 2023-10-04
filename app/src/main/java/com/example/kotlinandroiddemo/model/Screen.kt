package com.example.kotlinandroiddemo.model

import androidx.annotation.StringRes
import com.example.kotlinandroiddemo.R

sealed class Screen(val route: String, @StringRes val title: Int, val icon: Int) {
    object HomeScreen : Screen("homeScreen", R.string.homeScreen, R.drawable.home)
    object SearhScreen: Screen("searchScreen", R.string.searchScreen,R.drawable.search)
    object LoginScreen : Screen("loginScreen", R.string.loginScreen, R.drawable.user)
    object SettingScreen: Screen("settingScreen", R.string.settingScreen,R.drawable.repair)
}