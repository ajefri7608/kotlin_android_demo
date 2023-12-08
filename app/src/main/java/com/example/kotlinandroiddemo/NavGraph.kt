package com.example.kotlinandroiddemo

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinandroiddemo.model.Screen
import com.example.kotlinandroiddemo.view.bottomTab.bottomTabBar
import com.example.kotlinandroiddemo.view.common.BottomSheet
import com.example.kotlinandroiddemo.view.home.HomeScreen
import com.example.kotlinandroiddemo.view.login.LoginScreen
import com.example.kotlinandroiddemo.view.search.SearchScreen
import com.example.kotlinandroiddemo.view.setting.SettingScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            bottomTabBar(navController = navController)
        }
    ) { innerPadding ->
        BottomSheet()
        NavHost(
            navController,
            startDestination = Screen.HomeScreen.route,
        ) {
            composable(Screen.HomeScreen.route) { HomeScreen(navController) }
            composable(Screen.LoginScreen.route) { LoginScreen(navController) }
            composable(Screen.SearhScreen.route) { SearchScreen() }
            composable(Screen.SettingScreen.route) { SettingScreen() }
        }
    }
}



