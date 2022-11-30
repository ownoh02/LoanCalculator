package com.techstart.loancalculator.ui.view

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.techstart.loancalculator.viewmodels.CalculatorViewModel

@Composable
fun MainContent(
  //  viewModel: CalculatorViewModel = viewModel()
){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        BottomNavGraph(it,navController = navController )
    }
}