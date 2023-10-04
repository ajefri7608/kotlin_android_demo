package com.example.kotlinandroiddemo.view.bottomTab

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kotlinandroiddemo.model.Screen
import com.example.kotlinandroiddemo.ui.theme.Typography


@Composable
fun bottomTabBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        val items = listOf(
            Screen.HomeScreen,
            Screen.SearhScreen,
            Screen.LoginScreen,
            Screen.SettingScreen
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEachIndexed { index, screen ->
            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            BottomNavigationItem(
                icon = { BottomTabIcon(icon = screen.icon, selected) },
                label = { Text(text = stringResource(screen.title), color = Color("#748c94".toColorInt()), fontSize = 12.sp) },
                selected = selected,
                alwaysShowLabel = false,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}