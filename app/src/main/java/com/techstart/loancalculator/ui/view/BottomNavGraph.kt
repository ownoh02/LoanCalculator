package com.techstart.loancalculator.ui.view

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.techstart.loancalculator.ui.screen.CalculatorScreen
import com.techstart.loancalculator.ui.screen.EffectiveScreen
import com.techstart.loancalculator.ui.screen.FixedScreen
import com.techstart.loancalculator.viewmodels.CalculatorViewModel

//import com.techstart.loancalculator.viewmodels.CalculatorViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BottomNavGraph(
    paddingIntent: PaddingValues,
    navController: NavHostController,
    viewModel: CalculatorViewModel = viewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Calculator.route
    ) {
        coroutineScope.launch(Dispatchers.IO) {
            delay(1000)
            Log.e("TEST ", "Start")
        }
        composable(route = BottomBarScreen.Calculator.route) {
            CalculatorScreen(paddingIntent, navController,viewModel)
        }
        composable(route = BottomBarScreen.Effective.route) {
            EffectiveScreen()
        }
        composable(route = BottomBarScreen.Fixed.route) {
            FixedScreen()
        }
        composable(route = OtherScreen.Screen1.route) {
            EffectiveScreen()
        }
        composable(route = OtherScreen.Screen2.route) {
            FixedScreen()
        }
    }

}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Calculator,
        BottomBarScreen.Effective,
        BottomBarScreen.Fixed
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach {
            currentDestination?.let { it1 ->
                AddItem(
                    screen = it,
                    currentDestination = it1,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination.hierarchy.any {
            it.route == screen.route
        },
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}