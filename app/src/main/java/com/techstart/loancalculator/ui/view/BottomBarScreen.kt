package com.techstart.loancalculator.ui.view

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route : String,
    val title : String,
    val icon : ImageVector
){
    object Calculator : BottomBarScreen(
        route = "calculator",
        title = "Calculator",
        icon = Icons.Default.Home
    )

    object Effective : BottomBarScreen(
        route = "effective",
        title = "Effective",
        icon = Icons.Default.Home
    )

    object Fixed : BottomBarScreen(
        route = "fixed",
        title = "Fixed",
        icon = Icons.Default.Home
    )
}
