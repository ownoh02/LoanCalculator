package com.techstart.loancalculator.ui.view

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class OtherScreen(
    val route : String,
){
    object Screen1 : OtherScreen(
        route = "Screen1",
    )

    object Screen2 : OtherScreen(
        route = "Screen2",
    )

}
