package com.example.kotlinandroiddemo.view.bottomTab

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kotlinandroiddemo.model.Screen
import com.example.kotlinandroiddemo.model.ShakeConfig
import com.example.kotlinandroiddemo.ui.theme.Typography
import com.example.kotlinandroiddemo.utils.compose.shake
import com.example.kotlinandroiddemo.utils.rememberShakeController
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


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
        val scope = rememberCoroutineScope()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val iconOffset = remember { Animatable(0f) }
        items.forEachIndexed { index, screen ->
            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            val shakeController = rememberShakeController()
            BottomNavigationItem(
                icon = {
                    Image(
                        painter = painterResource(id = screen.icon),
                        modifier = Modifier
                            .shake(shakeController)
                            .size(21.dp),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(
                            if (selected == true) Color("#00c090".toColorInt()) else Color("#748c94".toColorInt())
                        )
                    )
                },
                label = {
                    Text(
                        text = stringResource(screen.title),
                        color = Color("#748c94".toColorInt()),
                        fontSize = 12.sp
                    )
                },
                selected = selected,
                alwaysShowLabel = false,
                onClick = {
                    shakeController.shake(
                        ShakeConfig(
                            iterations = 4,
                            intensity = 2_000f,
                            rotateY = 15f,
                            translateX = 40f,
                        )
                    )

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