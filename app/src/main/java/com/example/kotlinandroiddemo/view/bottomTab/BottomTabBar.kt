package com.example.kotlinandroiddemo.view.bottomTab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
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
import com.example.kotlinandroiddemo.utils.compose.shake


@Composable
fun bottomTabBar(navController: NavController) {

    NavigationBar(
        modifier = Modifier
            .offset(0.dp, 16.dp)
            .graphicsLayer {
                this.shape = RoundedCornerShape(33.dp, 33.dp, 0.dp, 0.dp);this.clip = true
            },
        containerColor = Color.White
    ) {
        val items = listOf(
            Screen.HomeScreen,
            Screen.SearhScreen,
            Screen.LoginScreen,
            Screen.SettingScreen
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val animList = remember {
            List(4) { index ->
                mutableStateOf(false)
            }
        }
        items.forEachIndexed { index, screen ->
            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(id = screen.icon),
                        modifier = Modifier
                            .shake(animList[index].value)
                            .size(21.dp),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(
                            if (selected) Color("#00c090".toColorInt()) else Color("#748c94".toColorInt())
                        )
                    )
                },
                label = {
                    Text(
                        text = stringResource(screen.title),
                        color = Color("#748c94".toColorInt()),
                        fontSize = 12.sp,
                        modifier = Modifier.offset(0.dp, (-7).dp)
                    )
                },
                selected = selected,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White
                ),
                alwaysShowLabel = false,
                onClick = {
                    animList[index].value = !animList[index].value
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